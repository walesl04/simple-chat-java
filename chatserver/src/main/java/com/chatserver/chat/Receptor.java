package com.chatserver.chat;

import java.util.Scanner;

public class Receptor implements Runnable {
    private Scanner input;
    private Distributor distributor;
    private String uuid;

    public Receptor(Scanner input, Distributor distributor, String uuid) {
        this.input = input;
        this.distributor = distributor;
        this.uuid = uuid;
    }

    @Override
    public void run() {
        while (this.input.hasNextLine()) {
            String msg = this.input.nextLine();
            this.distributor.deliveryMessage(msg, uuid);
        }
    }
}
