package inje.bim.other.client.notification.client;

import inje.bim.other.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationInterfaceClient {
    @Autowired
    Client bimServerClient;

/*    public List<SUser> getAllusers() throws ServiceException, PublicInterfaceNotFoundException {
        return bimServerClient.getServiceInterface().getAllUsers();
    }*/
}