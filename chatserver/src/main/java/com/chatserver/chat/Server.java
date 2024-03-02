package com.chatserver.chat;

import java.net.ServerSocket;
import org.apache.log4j.Logger;

public class Server {
    static final int PORT = 8081;
    public static Logger logger = Logger.getLogger(Server.class);

    public static void startChatServer() throws Exception {
        Distributor distributor = new Distributor();
        ServerSocket server = new ServerSocket(PORT);
        Enroll enroll = new Enroll(distributor, server);

        Thread threadServer = new Thread(enroll);
        threadServer.start();

        logger.info(String.format("Server running in %d PORT...", PORT));
    }
}
