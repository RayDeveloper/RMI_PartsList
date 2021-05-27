If the wrong option is chosen an appropriate message is sent. If the part name is not found, an appropriate message is sent to the client is entered. The program wwas tested on a home network using one machine (192.168.100.187). This machine acted as both the client and server.

**Input file**
=

The screenshot below shows the details of the parts separated by spaces. Some part names have a mixture of uppercase and lower-case letters. The program ensures the cases or spaces will not be a problem. 
 
![image](https://user-images.githubusercontent.com/12537673/119756148-20743280-be71-11eb-9648-60b523bbeb29.png)


**Output file**
=

The output file has the elapsed time of each transaction along with the date and timestamp.

![image](https://user-images.githubusercontent.com/12537673/119756243-47326900-be71-11eb-972c-2a06a54db428.png)

If the file is not present, it will create it using the following code.
![image](https://user-images.githubusercontent.com/12537673/119756261-4dc0e080-be71-11eb-8bcd-c89195720604.png)

The elapsed time is calculated using the following code. In the screenshot we see that before the method is called there is a “start” variable that tracks the start time of the response. The “end” variable tracks the end of the transaction. Once that has been done it does a calculation using the start and end times and writes it to the file “output.dat” along with the date and time stamp. The time is given in seconds.

![image](https://user-images.githubusercontent.com/12537673/119756294-56b1b200-be71-11eb-8123-847d0e0b2921.png)

Execution
==

Transaction 1 (get the selling price of a part)

![image](https://user-images.githubusercontent.com/12537673/119756374-75b04400-be71-11eb-99d5-438305572a8b.png)

Transaction 2 (View the entire list of parts)

![image](https://user-images.githubusercontent.com/12537673/119756393-7d6fe880-be71-11eb-9bc0-f134defff292.png)

Transaction 3 (Change a selling price)

![image](https://user-images.githubusercontent.com/12537673/119756417-852f8d00-be71-11eb-9ee4-de54672c2bdb.png)


Transaction 4 (delete a part)

![image](https://user-images.githubusercontent.com/12537673/119756434-8bbe0480-be71-11eb-8df5-d2f5c8affe7f.png)

Transaction 5 (Total profit)

![image](https://user-images.githubusercontent.com/12537673/119756463-95e00300-be71-11eb-82ba-5d67813ed14f.png)

Transaction 6 (Extra Feature)

![image](https://user-images.githubusercontent.com/12537673/119756481-9d071100-be71-11eb-9947-3a9ddf725399.png)

**Extra Feature**
=

The extra feature implemented is the ability to get the part with the most sales.

Input
The input for this is simply enter the number 6 as described by the “MENU”.
![image](https://user-images.githubusercontent.com/12537673/119756529-aabc9680-be71-11eb-9489-26dbd2513503.png)

Processing
Opening the input file and storing them into an ArrayList with object type of “Persons”.
![image](https://user-images.githubusercontent.com/12537673/119756553-b14b0e00-be71-11eb-8f5d-c6da4edaf715.png)

It is added to the arraylist until the file has no more lines.

![image](https://user-images.githubusercontent.com/12537673/119756581-b9a34900-be71-11eb-89f1-da687c5d023f.png)

Next, at the beginning of the execution of the extra feature, max is declared as 0, then each time it compares the sales of a part with the current max, if it is more it assigns that variable as the current high. It keeps going until the end of the arraylist.

![image](https://user-images.githubusercontent.com/12537673/119756605-bf992a00-be71-11eb-9e9f-9f23d30f049c.png)

Output
The output displays the part name along with the total number of units sold.
![image](https://user-images.githubusercontent.com/12537673/119756619-c758ce80-be71-11eb-9aad-f92517d26416.png)

![image](https://user-images.githubusercontent.com/12537673/119756633-cc1d8280-be71-11eb-9921-22e42e74e573.png)

Performance
==

Response time deals with the total time between an initial request for service from the user and the fulfillment of that request by the server. Low response times are best as they are very critical to the success of the program. This program response time were calculated using the followings program commands. Each transaction had a start and end variable which were of variable type “long”. The programs were tested on a home network using one machine (192.168.100.187). This machine acted as both the client and server.

![image](https://user-images.githubusercontent.com/12537673/119757786-777b0700-be73-11eb-962c-3d6db36efe59.png)


![image](https://user-images.githubusercontent.com/12537673/119757790-7a75f780-be73-11eb-9617-666b6205538f.png)


In the screenshot we see that before the method is called there is a “start” variable that tracks the start time of the response. The “end” variable tracks the end of the transaction. Once that has been done it does a calculation using the start and end times and writes it to the file “output.dat” along with the date and time stamp. The time is given in seconds.

Transaction 1(Getting selling price of a part)
 
![image](https://user-images.githubusercontent.com/12537673/119757827-8a8dd700-be73-11eb-869e-a3ee35a6797e.png)

Transaction 2(viewing the entire parts list)

![image](https://user-images.githubusercontent.com/12537673/119757846-9083b800-be73-11eb-964d-566d1218ece9.png)

Transaction 3(changing the selling price of a part)]

![image](https://user-images.githubusercontent.com/12537673/119757865-97aac600-be73-11eb-9893-76994e6184d8.png)

Transaction 4(deleting a part)

![image](https://user-images.githubusercontent.com/12537673/119757882-9f6a6a80-be73-11eb-9de8-5e1f37b9e502.png)

Transaction 5(get the total profit)

![image](https://user-images.githubusercontent.com/12537673/119757908-a6917880-be73-11eb-98d2-d1a86787da77.png)










