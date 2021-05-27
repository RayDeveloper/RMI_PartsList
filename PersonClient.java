//The programs were tested on a home network using one machine (192.168.100.187). This machine acted as both the client and server.
//Raydon Davis ,UWI ID:  813117991

import java.rmi.*;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.*;
import java.util.*;
import java.text.*;
import java.sql.Timestamp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.*;

//client file that will call PersonServerIntf and use method declarations from it
public class PersonClient {
	@SuppressWarnings("unchecked")
  public static void main (String args [])  {

  	 long duration=0;
  	 long startTime=0;
  	 long start=0;
  	 long end=0;

  	try {
  		Scanner input = new Scanner(System.in);
  		 String[] allPartsList = new String[10];
  		 File myfile = new File("output.out");
  		 if(!myfile.exists()){
        myfile.createNewFile();//if the output file doesn't exisit ,then create it.
    }
		   FileWriter fileWriter = new FileWriter(myfile, true);

    	BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
  		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
  		 NumberFormat formatter = new DecimalFormat("#0.00000");

  	  System.out.println("Running client.\n");

  	  System.out.println("MENU\n");
  	  System.out.println("Enter 1 to get selling price.");
  	  System.out.println("Enter 2 to view entire list of parts.");
  	  System.out.println("Enter 3 to change the selling price.");
  	  System.out.println("Enter 4 to delete a part.");
  	  System.out.println("Enter 5 to get Total profit.");
  	  System.out.println("Enter 6 to launch the extra feature.\n");

  	  String inputString = input. nextLine();
  	  String personServerURL = "rmi://" + "localhost" + "/PersonServer";
  	  PersonServerIntf personServerIntf = (PersonServerIntf)Naming.lookup(personServerURL);

  	  switch(inputString) {
  case "1":
  	System.out.print("Enter name of part:  ");
  	String partName = input. nextLine();
     start = System.currentTimeMillis();
    //String finalPartName = partName.toUpperCase();
   	String finalPartName2= partName.replaceAll("\\s+","");//removes spaces
    int sellprice = personServerIntf.getPrice(finalPartName2);
     end = System.currentTimeMillis();
    if (sellprice == -1){
    System.out.print("The Part was not found.");
    end = System.currentTimeMillis();
    }else{
	System.out.print("The cost of the part is:$"+ sellprice);
	bufferedWriter.write("Menu option 1's Elapsed time:" + formatter.format((end - start) / 1000d) + " seconds, ");
	bufferedWriter.write(timestamp+"\n");
    bufferedWriter.close();
    }


    break;
  case "2":
    start = System.currentTimeMillis();
   allPartsList =personServerIntf.allParts(inputString);
   for(int i=0;i<allPartsList.length ; i++){
   	 if(allPartsList[i] != null)
   	System.out.println("" + allPartsList[i]);
   }
    end = System.currentTimeMillis();
	bufferedWriter.write("Menu option 2's Elapsed time:" + formatter.format((end - start) / 1000d) + " seconds, ");
	bufferedWriter.write(timestamp+"\n");
    bufferedWriter.close();
    break;

    case "3":
    	String[] FinalArray = new String[30];
    System.out.print("Enter name of part you would like to change the price of: ");
  	String Name = input. nextLine();
   	String changeName= Name.replaceAll("\\s+","");//removes spaces
    System.out.print("Enter the new price: ");
    int newPrice = input. nextInt();
    start = System.currentTimeMillis();
     FinalArray = personServerIntf.changeSell(changeName,newPrice);
	   if (FinalArray[0].equals("-1") ){
	   		 System.out.print("The Part was not found.\n");
    		end = System.currentTimeMillis();
	   }else{
   	System.out.println("The new List with price change:");
   	for (int x=0;x <=FinalArray.length -1 ; x++){

   		System.out.println(FinalArray[x]);
   	}
   	end = System.currentTimeMillis();
	bufferedWriter.write("Menu option 3's Elapsed time:" + formatter.format((end - start) / 1000d) + " seconds, ");
	bufferedWriter.write(timestamp+"\n");
    bufferedWriter.close();

	   	}//end if

    break;
        case "4":
     ArrayList<Person> FinalDel = new ArrayList<Person>();
    System.out.print("Enter name of part you would like to delete: ");
  	 Name = input. nextLine();
  	 String delName= Name.replaceAll("\\s+","");//removes spaces
  	 //String upperName= Name.toUpperCase();
  	 start = System.currentTimeMillis();
     FinalDel = personServerIntf.delPart(delName);

    Person p = FinalDel.get(0) ;
	   if (p.getpartName().equals("-1")){
    System.out.print("The Part was not found.\n");
    end = System.currentTimeMillis();
	   }else{
    System.out.print("Part Deleted. New List\n");
   	for (int x=0;x <FinalDel.size() ; x++){

   		System.out.println(FinalDel.get(x));
   	}//end for
    end = System.currentTimeMillis();
	   }//end if
	bufferedWriter.write("Menu option 4's Elapsed time:" + formatter.format((end - start) / 1000d) + " seconds, ");
	bufferedWriter.write(timestamp+"\n");
    bufferedWriter.close();
    break;
            case "5":
    System.out.print("The total profit will be calculated... \n");
    start = System.currentTimeMillis();
    int prof = personServerIntf.totalProfit();
	System.out.print("The total profit is : $"+prof);
	end = System.currentTimeMillis();
	bufferedWriter.write("Menu option 5's Elapsed time:" + formatter.format((end - start) / 1000d) + " seconds, ");
	bufferedWriter.write(timestamp+"\n");
    bufferedWriter.close();
    break;
    case "6":
	String highestPart = personServerIntf.extraFeature();
	System.out.print(""+highestPart);

	break;
	  default:
	  System.out.print("You entered a wrong choice:");
}

  }catch (Exception e)  {
  	System.out.println("Exception: " + e);
  	}


  }//end main


}//end personclient

