package com.dosomedev;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public void run() {
        try {
            // Create registry on port 1099.
            Registry registry = LocateRegistry.createRegistry(1099);

            // Create an instance of the remote object.
            CalculatorImpl calculator = new CalculatorImpl();

            // Bind the remote object to the registry with a name.
            registry.bind("CalculatorService", calculator);

            System.out.println("Calculator server started...");
        } catch (RemoteException e) {
            System.err.println("Error: Could not create registry.");
        } catch (AlreadyBoundException e) {
            System.err.println("Error: Name in registry already used for binding.");
        }
    }
}
