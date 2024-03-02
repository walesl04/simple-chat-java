package com.chatclient.chat;

import java.io.PrintStream;

public class Issuer {
    private PrintStream outStream;

    public Issuer(PrintStream outStream) {
        this.outStream = outStream;
    }

    public void send(String message) {
        this.outStream.println(message);
    }
}