package com.chatserver.chat;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

import org.apache.log4j.Logger;

public class Enroll implements Runnable {
    public static Logger logger = Logger.getLogger(Server.class);

    private Distributor distributor;
    private ServerSocket server;

    public Enroll(Distributor distributor, ServerSocket server) {
        this.distributor = distributor;
        this.server = server;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket client = this.server.accept();
                String uuidChat = UUID.randomUUID().toString();
                logger.info("NEW CLIENT CONNECTED");

                Scanner input = new Scanner(client.getInputStream());
                PrintStream output = new PrintStream(client.getOutputStream());

                Receptor receptor = new Receptor(input, this.distributor, uuidChat);
                Thread stack = new Thread(receptor);
                stack.start();

                Issuer issuer = new Issuer(output, uuidChat);

                this.distributor.addIssuer(issuer);

            } catch (Exception exception) {
                System.out.println(("chat:failed").concat(exception.getMessage()));
            }
        }
    }
}
