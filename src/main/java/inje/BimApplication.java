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
        BimServerClient bimServerClient = factory.create(new UsernamePasswordAuthenticationInfo(bimserverUsername, bimserverPassword));
/*        bimServerClient.setToken("BD69DC7EA906AC49E9CE31D087236714");//kyoyaiida@injeinc.co.kr
        bimServerClient.setToken("FDD4E7595F15F808B25B8CC985BDF85E");//iwonsiks@hotmail.com
        bimServerClient.setToken("B1C1482AA4FEF6DD59A9E70F8DC2B6CA");//wskim@injeinc.co.kr
        bimServerClient.setToken("7D83B8901BFACEA4D9B44E4F425B755A");//kyoyaiida83@gmail.com
        bimServerClient.setToken("A878BCC616880D1CA227394E74BBF075");//kyoyaiida@naver.com
        bimServerClient.setToken("475CB9519065AC85C27570B4C43D00A1");//jjy_5212@injeinc.co.kr*/

        return bimServerClient;
    }

}