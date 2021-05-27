//Raydon Davis ,UWI ID:  813117991
//The programs were tested on a home network using one machine (192.168.100.187). This machine acted as both the client and server.
import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.*;
import java.util.*;

public class  PersonServerImpl extends UnicastRemoteObject
  implements  PersonServerIntf {

  public PersonServerImpl() throws RemoteException, IOException {
  	}

  public String[] changeSell (String partName, int newPrice ) throws RemoteException {
  	String[] split = new String[3];
  	int flag = 0;
  	ArrayList <Person> list = new ArrayList<Person>();
  	String[] partsarr = new String[10];
  	String[] partsarr2 = {"-1"};
  	String notfound="This is not found";
  	boolean acceptArgument = false;

	try{

  	File partsFile = new File("input.dat");
  	FileWriter fileWriter = new FileWriter(partsFile,true);

      Scanner myReader = new Scanner(partsFile);
      while (myReader.hasNextLine() ){
        String data = myReader.nextLine();
         split= data.split(" ");
        Person garage= new Person (split[0],Integer.parseInt(split[1]),Integer.parseInt(split[2]),Integer.parseInt(split[3]));
        list.add(garage);
      }//end while

      flag = partChecker (list,partName);

			if(flag==-1){

				return partsarr2;
			}else{
	        for (int i = 0 ; i < 10 ;i++) {
     	Person p = list.get(i) ;
         if(p.getpartName().equalsIgnoreCase(partName)){
    	p.updateSellPrice(newPrice);
    	partsarr[i]= p.toString();
    }//end if
    partsarr[i]= p.toString();
    }//end for
			}//end if




	myReader.close();
	} catch (IOException e ){
		e.printStackTrace();
	}

 	return partsarr;



  }//end changesell

  public String[] allParts (String line) throws RemoteException{
  	String[] Partsarray = new String[20];
  	int s=0;
  		if(line.equals("2")){
  		  		try{

       File partsFile = new File("input.dat");
      Scanner myReader = new Scanner(partsFile);
      while (myReader.hasNextLine() ){
        String data = myReader.nextLine();
        Partsarray[s]=data;
        s++;
      }//end while
      myReader.close();
	} catch (FileNotFoundException e){
		e.printStackTrace();
	}
  		}//end if

  		return Partsarray;

}// end allParts

  public int getPrice (String line) throws RemoteException{
  	String[] split = new String[3];
	ArrayList <Person> list = new ArrayList<Person>();
  	String partnotFound= "The part has not been found";
  	String[] Partsarray = new String[20];
  	String[] splitPart = new String[3];
  	int s=0;
  	try{
       File partsFile = new File("input.dat");
      Scanner myReader = new Scanner(partsFile);
      while (myReader.hasNextLine() ){
      	 String data = myReader.nextLine();
         split= data.split(" ");
        Person garage= new Person (split[0],Integer.parseInt(split[1]),Integer.parseInt(split[2]),Integer.parseInt(split[3]));
        list.add(garage);
        System.out.println(data);

      }//end while
      myReader.close();
	} catch (FileNotFoundException e){
		e.printStackTrace();
	}

	   for(int i=0;i< list.size() ; i++){

		Person p = list.get(i) ;
   	 	if(p.getpartName().equalsIgnoreCase(line)){
   	 		return p.getsellPrice();
   	 	}//end if
	   }//end for
return -1;
  }// end getPrice





 public ArrayList delPart (String partName) throws RemoteException {
		int flag=0;
 	  	String[] partsarr = new String[9];
  	String[] partsarr2 = {"-1"};
  	int nothere= 0;
  	String[] split = new String[3];
  	ArrayList <Person> list = new ArrayList<Person>();
  	ArrayList<Person> P2 = new ArrayList<Person>();
  	Person NotFound = new Person("-1",0,0,0);
  	P2.add(NotFound);
  	String notfound="This is not found";

	try{

  	File partsFile = new File("input.dat");

      Scanner myReader = new Scanner(partsFile);
      while (myReader.hasNextLine() ){
        String data = myReader.nextLine();
         split= data.split(" ");
        Person garage= new Person (split[0],Integer.parseInt(split[1]),Integer.parseInt(split[2]),Integer.parseInt(split[3]));
        list.add(garage);
      }//end while

    flag= partChecker( list,partName);

    	if(flag== -1){

    		return P2;
    	}else{


 	        for (int i = 0 ; i <= list.size()-1 ;i++) {
     	Person p = list.get(i) ;
         if(p.getpartName().equalsIgnoreCase(partName)){
    		nothere=i;
        }

    }//end for
    list.remove(list.get(nothere));
   for (int y = 0 ; y <=list.size()-1 ;y++) {
   	Person p = list.get(y) ;
 	partsarr[y]= p.toString();
  }
    	myReader.close();
    	}//end if






	} catch (IOException e ){
		e.printStackTrace();
	}//end catch


    return list;

  }



public int totalProfit () throws RemoteException {
 	int returnvariable = 0 ;
  	String[] split = new String[3];
  	ArrayList <Person> list = new ArrayList<Person>();
  	String notfound="This is not found";
  	int totalProfit = 0;
  	int finalProfit =0;

	try{

  	File partsFile = new File("input.dat");

      Scanner myReader = new Scanner(partsFile);
      while (myReader.hasNextLine() ){
        String data = myReader.nextLine();
         split= data.split(" ");
        Person garage= new Person (split[0],Integer.parseInt(split[1]),Integer.parseInt(split[2]),Integer.parseInt(split[3]));
        totalProfit =( Integer.parseInt(split[2]) -Integer.parseInt(split[1]) ) * Integer.parseInt(split[3]);
        finalProfit = finalProfit+ totalProfit;
      }//end while
		myReader.close();


	} catch (IOException e ){
		e.printStackTrace();
	}

	      return finalProfit ;

  }//end totalProfit






public int partChecker (ArrayList partNames,String partName) throws RemoteException {
	int val = -1;
        for(int i=0; i < partNames.size(); i++){
        	Person p = (Person)partNames.get(i);
        	if(p.getpartName().equalsIgnoreCase(partName))
        		val=1;
        }//end for
        return val;

}//end PartChecker


public String extraFeature (){
		int max=0;
		String maxName="";
	 	int returnvariable = 0 ;
	 	String highestPart="";
  	String[] split = new String[3];
  	ArrayList <Person> list = new ArrayList<Person>();
  	String notfound="This is not found";
  	int totalProfit = 0;
  	int finalProfit =0;

	try{

  	File partsFile = new File("input.dat");

      Scanner myReader = new Scanner(partsFile);
      while (myReader.hasNextLine() ){
        String data = myReader.nextLine();
         split= data.split(" ");
        Person garage= new Person (split[0],Integer.parseInt(split[1]),Integer.parseInt(split[2]),Integer.parseInt(split[3]));
        list.add(garage);
      }//end while
		myReader.close();
		 for (int i = 0 ; i < list.size(); i++) {
     			Person p = list.get(i) ;
     			if(p.getquantitySold()>max){//compares the current high with the next part sales
     				max=p.getquantitySold();
     				maxName=p.getpartName();
     			}//end if
		        }//end for

	} catch (IOException e ){
		e.printStackTrace();
	}
        String uppermax = maxName.toUpperCase();
         highestPart = "The Highest sold part is "+uppermax+" with "+max+" units sold.";

	      return highestPart ;

}//end extraFeature







  }//end PersonServerIntf






