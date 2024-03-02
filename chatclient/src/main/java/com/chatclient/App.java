package com.chatclient;

import org.apache.log4j.Logger;

import com.chatclient.chat.Client;

public class App {
    public static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        try {
            Client.startClient();
        } catch (Exception exception) {
            logger.info(exception.getMessage());
        }
    }
}
