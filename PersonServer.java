//Raydon Davis ,UWI ID:  813117991
//The programs were tested on a home network using one machine (192.168.100.187). This machine acted as both the client and server.
import java.net.*;
import java.rmi.*;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.*;
import java.util.*;


//calls the personServerImpl file
public class  PersonServer  {
  public static void main (String args [])  {
  	try {
  	  PersonServerImpl  personServerImpl = new  PersonServerImpl();
  	  Naming.rebind("PersonServer",  personServerImpl);
  	}
  	catch (Exception e)  {
  	System.out.println("Exception: " + e);
  	}
  }
}

