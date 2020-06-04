package com.geekbrains.java2.lesson6.homework;

import java.net.*;
import java.io.*;
import java.util.*;

public class Client  {
    private String notif = " *** ";
    private ObjectInputStream sInput;
    private ObjectOutputStream sOutput;
    private Socket socket;
    private String server, username;
    private int port;

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    Client(String server, int port, String username) {
        this.server = server;
        this.port = port;
        this.username = username;
    }

    public boolean start() {
        try {
            socket = new Socket(server, port);
        } catch(Exception ec) {
            display("Error connectiong to server:" + ec);
            return false;
        }

        String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
        display(msg);

        try {
            sInput  = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException eIO) {
            display("Exception creating new Input/output Streams: " + eIO);
            return false;
        }

        new ListenFromServer().start();
        try {
            sOutput.writeObject(username);
        } catch (IOException eIO) {
            display("Exception doing login : " + eIO);
            disconnect();
            return false;
        }
        return true;
    }

    private void display(String msg) { System.out.println(msg); }

    void sendMessage(Chat msg) {
        try {
            sOutput.writeObject(msg);
        } catch(IOException e) {
            display("Exception writing to server: " + e);
        }
    }

    private void disconnect() {
        try {
            if(sInput != null) sInput.close();
        } catch(Exception e) {}
        try {
            if(sOutput != null) sOutput.close();
        } catch(Exception e) {}
        try{
            if(socket != null) socket.close();
        } catch(Exception e) {}

    }

    public static void main(String[] args) {
        int portNumber = 1500;
        String serverAddress = "localhost";
        String userName = "Anonymous";
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the username: ");
        userName = scan.nextLine();

        switch(args.length) {
            case 3:
                serverAddress = args[2];
            case 2:
                try {
                    portNumber = Integer.parseInt(args[1]);
                }
                catch(Exception e) {
                    System.out.println("Invalid port number.");
                    System.out.println("Usage is: > java Client [username] [portNumber] [serverAddress]");
                    return;
                }
            case 1:
                // for > javac Client username
                userName = args[0];
            case 0:
                break;
            default:
                System.out.println("Usage is: > java Client [username] [portNumber] [serverAddress]");
                return;
        }
        Client client = new Client(serverAddress, portNumber, userName);
        if(!client.start())
            return;

        System.out.println("\nHello.! Welcome to the chat.");
        System.out.println("Instructions:");
        System.out.println("1. Simply type the message to send broadcast to all active clients");
        System.out.println("2. '@username<space>yourmessage' without any quotes to send message to desired client");
        System.out.println("3. 'WHOISIN' without quotes to see list of active clients");
        System.out.println("4. 'LOGOUT' without quotes to logoff from server");
        while(true) {
            System.out.print("> ");
            String msg = scan.nextLine();
            if(msg.equalsIgnoreCase("LOGOUT")) {
                client.sendMessage(new Chat(Chat.LOGOUT, ""));
                break;
            } else if(msg.equalsIgnoreCase("WHOISIN")) {
                client.sendMessage(new Chat(Chat.WHOISIN, ""));
            } else {
                client.sendMessage(new Chat(Chat.MESSAGE, msg));
            }
        }
        scan.close();
        client.disconnect();
    }

    class ListenFromServer extends Thread {

        public void run() {
            while(true) {
                try {
                    String msg = (String) sInput.readObject();
                    System.out.println(msg);
                    System.out.print("> ");
                } catch(IOException e) {
                    display(notif + "Server has closed the connection: " + e + notif);
                    break;
                } catch(ClassNotFoundException e2) {
                    System.out.println("1");
                }
            }
        }
    }
}