package inje.bimclient.bim.notificationInterface.dao;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationInterfaceDao {
    @Autowired
    BimServerClient bimServerClient;

    public List<SUser> getAllusers() throws ServiceException, PublicInterfaceNotFoundException {
        return bimServerClient.getServiceInterface().getAllUsers();
    }
}