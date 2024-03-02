package com.chatclient.chat;

import java.util.Scanner;

import com.chatclient.views.ViewMessages;

public class Receptor implements Runnable {
    private Scanner input;
    private ViewMessages view;

    public Receptor(Scanner input, ViewMessages view) {
        this.input = input;
        this.view = view;
    }

    @Override
    public void run() {
        while (this.input.hasNextLine()) {
            String msg = this.input.nextLine();
            this.view.addMessages(msg);
        }
    }
}
