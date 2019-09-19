package inje.bim.client;

import org.bimserver.client.BimServerClient;

public class BimServerClientContext {
    private static final ThreadLocal<BimServerClient> CONTEXT = new ThreadLocal<BimServerClient>();
    private static final ThreadLocal<String> USERNAME = new ThreadLocal();

    public static void setBimServerClient(BimServerClient bimServerClient) {
        CONTEXT.set(bimServerClient);
    }

    public static BimServerClient getBimServerClient() {
        return CONTEXT.get();
    }

    public static void clearBimServerClient() {
        CONTEXT.remove();
    }

    public static void setUsername(String username) {
        USERNAME.set(username);
    }

    public static String getUsername() {
        return USERNAME.get();
    }

    public static void clearUsername() {
        USERNAME.remove();
    }
}