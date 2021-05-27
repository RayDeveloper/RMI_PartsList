//Raydon Davis ,UWI ID:  813117991
//The programs were tested on a home network using one machine (192.168.100.187). This machine acted as both the client and server.
import java.rmi.*;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.*;
import java.util.*;


public interface PersonServerIntf extends Remote {
  String[] changeSell (String p1, int p2) throws RemoteException;

    ArrayList delPart (String p1) throws RemoteException;

  String[] allParts(String line)throws RemoteException;

  int getPrice(String line) throws RemoteException;

  int  partChecker (ArrayList partNames,String partName) throws RemoteException;

  int totalProfit()throws RemoteException;

  String extraFeature() throws RemoteException;


}


	 //contains the methods used in personServerImpl
	 //just the declarations?