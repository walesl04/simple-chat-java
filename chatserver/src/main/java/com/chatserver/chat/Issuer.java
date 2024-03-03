package com.chatserver.chat;

import java.io.PrintStream;

public class Issuer {
    private PrintStream outStream;
    private String uuid;

    public Issuer(PrintStream outStream, String uuid) {
        this.outStream = outStream;
        this.uuid = uuid;
    }

    public String getUUID() {
        return this.uuid;
    }

    public void send(String message) {
        this.outStream.println(message);
    }
}
