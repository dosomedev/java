package com.dosomedev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public void run() {
        int portNumber = 12345;
        
        try (ServerSocket socket = new ServerSocket(portNumber)) {
            System.out.println("Simple server listening on port " + portNumber + ".");

            // Wait for the client to connect.
            Socket clientSocket = socket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Input from the client.
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            ) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Server received: " + inputLine);
                    out.println("Server says: " + inputLine.toUpperCase());
                    if (inputLine.equalsIgnoreCase("bye")) {
                        break;
                    }
                }
            } catch (IOException ex) {
                System.err.println("Error handling client: " + ex.getMessage());
            } finally {
                clientSocket.close();
            }
        } catch (IOException ex) {
            System.err.println("Could not listen on port " + portNumber + ": " + ex.getMessage());
        }
    }
}
