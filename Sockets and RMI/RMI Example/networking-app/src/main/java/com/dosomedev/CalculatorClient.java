package com.dosomedev;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public void run(String serverName) {
        try {
            // Get the registry on the server's host and port.
            Registry registry = LocateRegistry.getRegistry(serverName, 1099);

            // Look up the remote object by its name.
            RemoteCalculator calculator = (RemoteCalculator) registry.lookup("CalculatorService");

            // Invoke the remote method.
            int a = 5;
            int b = 3;

            System.out.println("Sending request to the server = " + serverName + " to add a = " + a + " and b = " + b + ".");
            int result = calculator.add(a, b);
            System.out.println("Response from the server = " + serverName + " with the result = " + result + ".");
        } catch (RemoteException e) {
            System.err.println("Error: Could not get registry.");
        } catch (NotBoundException e) {
            System.err.println("Error: Could not bind name in registry.");
        }
    }
}
