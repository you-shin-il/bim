package inje;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class )
public class BimApplication extends SpringBootServletInitializer {
    @Value("${bimserver.address}")
    private String bimserverAddress;
    @Value("${bimserver.username}")
    private String bimserverUsername;
    @Value("${bimserver.password}")
    private String bimserverPassword;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BimApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BimApplication.class, args);
    }

    @Bean
    public BimServerClient getJsonBimServerClientFactory() throws BimServerClientException, ServiceException, ChannelConnectionException {
        JsonBimServerClientFactory factory = new JsonBimServerClientFactory(bimserverAddress);
        return factory.create(new UsernamePasswordAuthenticationInfo(bimserverUsername, bimserverPassword));
    }

}
