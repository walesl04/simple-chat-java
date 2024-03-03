package com.chatclient.chat;

import com.chatclient.App;
import com.chatclient.views.ViewMessages;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class CommandLine implements ViewMessages {
    public static Logger logger = Logger.getLogger(CommandLine.class);

    private Issuer issuer;
    private String localMsg = "";
    private String userName;

    public CommandLine(Issuer issuer) {
        this.issuer = issuer;
    }

    public void init() {

        logger.info("Enter username:");
        Scanner input = new Scanner(System.in);
        userName = input.nextLine();
        System.out.println("\n\n");
        System.out.println("Welcome Chat!\n");
        System.out.println("🇩​🇦​🇷​🇰​ 🇨​🇭​🇦​🇹​ ₁.₀\n");
        System.out.print(">>> ");
        while (localMsg != "close-chat") {
            localMsg = input.nextLine();
            System.out.print(">>> ");
            this.sendMessage(userName.concat("#separator#").concat(localMsg));
        }
        input.close();
    }

    public void sendMessage(String msg) {
        this.issuer.send(msg);
    }

    public void addMessages(String msg) {
        String[] values = msg.split("#separator#");
        System.out.print("\n");
        logger.info(values[0].concat(" >>> ").concat(values[1]));
        System.out.print(">>> ");
    }
}
