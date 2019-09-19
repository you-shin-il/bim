package inje.bim.notificationInterface.client;

import inje.bim.client.Client;
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