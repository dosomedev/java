package com.dosomedev;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteCalculator extends Remote {
    int add(int a, int b) throws RemoteException;
}
