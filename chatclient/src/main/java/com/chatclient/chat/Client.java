package com.chatclient.chat;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import com.chatclient.chat.CommandLine;
import com.chatclient.views.ViewMessages;

public class Client {

    public static void startClient() throws Exception {
        Socket socket = new Socket("127.0.0.1", 8081);

        PrintStream output = new PrintStream(socket.getOutputStream());

        Scanner input = new Scanner(socket.getInputStream());

        Issuer issuer = new Issuer(output);

        ViewMessages view = new CommandLine(issuer);

        Receptor receptor = new Receptor(input, view);
        Thread stack = new Thread(receptor);
        stack.start();
        view.init();
    }
}
