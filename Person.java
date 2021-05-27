//The programs were tested on a home network using one machine (192.168.100.187). This machine acted as both the client and server.
//Raydon Davis ,UWI ID:  813117991
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.*;

public class Person implements java.io.Serializable {
    public String PartName;
    public int costPrice;
    public int sellPrice;
    public int quantitySold;

    public Person(String part, int cos, int sellp, int quan) {
        PartName = part;
        costPrice = cos;
        sellPrice = sellp;
        quantitySold = quan;
    }

    public String getpartName () {
        return PartName;
    }

    public int getcostPrice () {
        return costPrice;
    }

    public int getsellPrice () {
        return sellPrice;
    }

   public int getquantitySold () {
        return quantitySold;
    }


    public void updateOrders(int change){

        //orders = orders + change;
    }//

    public void updateSellPrice(int price1){
    	sellPrice = price1;

    }


public void updateSell(int newSellPrice){
	 sellPrice=newSellPrice;

}

    public String toString() {
       return new String(PartName +  " " + costPrice + " " +  sellPrice+" "+ quantitySold);
    }


    public static void main (String args[]) {
        ArrayList <Person> list = new ArrayList<Person>();



}// end Person
}

