package inje;

import inje.bim.server.BimServerProperties;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class )
public class BimApplication extends SpringBootServletInitializer {
    @Autowired
    BimServerProperties bimServerProperties;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BimApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BimApplication.class, args);
    }
    @Bean
    public JsonBimServerClientFactory jsonBimServerClientFactory() throws BimServerClientException {
        return new JsonBimServerClientFactory(bimServerProperties.getAddress());
    }

    @Bean
    public BimServerClient adminBimServerClient() throws BimServerClientException, ServiceException, ChannelConnectionException {
        BimServerClient bimServerClient = this.jsonBimServerClientFactory().create(new UsernamePasswordAuthenticationInfo(bimServerProperties.getUsername(), bimServerProperties.getPassword()));
        return bimServerClient;
    }

}