package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    static int port = 8089;
    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // сервер сокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) throws IOException {

        System.out.println("Server started");
        Scanner scanner = new Scanner(System.in);

        String username;
        String isChild;

        try(ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try(Socket clientSocket = server.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                ) {

                    out.write("Hello client! Write your name : \n");
                    out.flush();
                    username = in.readLine();

                    out.write("Are you child? (yes/no): : \n");
                    out.flush();
                    isChild = in.readLine();

                    if (isChild.equals("yes")) {
                        out.write(String.format("Welcome to the kids area, %s! Let's play!", username));
                    } else {
                        out.write(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", username));
                    }
                    out.flush();

                }
            }

        }

    }
}
