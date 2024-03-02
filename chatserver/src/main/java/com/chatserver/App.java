package com.chatserver;

import org.apache.log4j.Logger;

import com.chatserver.chat.Server;

public class App {
    public static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        try {
            Server.startChatServer();
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
    }
}
