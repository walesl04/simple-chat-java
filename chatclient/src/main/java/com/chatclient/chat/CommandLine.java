package com.chatclient.chat;

import com.chatclient.App;
import com.chatclient.views.ViewMessages;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class CommandLine implements ViewMessages {
    public static Logger logger = Logger.getLogger(CommandLine.class);

    private Issuer issuer;
    private String localMsg = "";

    public CommandLine(Issuer issuer) {
        this.issuer = issuer;
    }

    public void init() {
        String msg = "";
        Scanner input = new Scanner(System.in);
        while (msg != "close-chat") {
            localMsg = input.nextLine();
            this.sendMessage(localMsg);
        }
        input.close();
    }

    public void sendMessage(String msg) {
        this.issuer.send(msg);
    }

    public void addMessages(String msg) {
        if (!localMsg.equals(msg)) {
            logger.info(msg);
        }
    }
}
