package com.dosomedev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
    public void run(String serverName) {
        int portNumber = 12345;

        try (
            Socket socket = new Socket(serverName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
        ) {
            String userInput;
            String serverResponse;

            System.out.println("Connected to server " + serverName + ":" + portNumber);
            while (true) {
                System.out.print("Enter message (or 'bye' to quit): ");
                userInput = scanner.nextLine();
                out.println(userInput);

                serverResponse = in.readLine();
                System.out.println("Server response: " + serverResponse);

                if (userInput.equalsIgnoreCase("bye")) {
                    break;
                }
            }
            System.out.println("Disconnected from server.");
        } catch (IOException ex) {
            System.err.println("Couldn't get I/O for the connection to " + serverName);
        }
    }
}
