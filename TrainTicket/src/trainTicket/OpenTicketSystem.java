package trainTicket;
import java.time.LocalDate; // import the LocalDate class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.Random;
import java.util.Scanner;



public class OpenTicketSystem {
	private String departStation, arriveStation;
	String[] stations = {"New York City", "Buffalo","Rochester","Yonkers","Syracuse"};
	Scanner read = new Scanner(System.in);
	public void startApplication() {
		
		start();
		departFrom();	
		arriveTo();
		ticketPrice();
		read.close();

	}
	
public void start() {//Method to get input from user
	LocalDate today = LocalDate.now(); //Gets current Date
	DateTimeFormatter updateTime =  DateTimeFormatter.ofPattern("dd-MMM-yyyy");// Formats Date into a pattern
	String format = today.format(updateTime);// Sets formated date to a string
	
	String availableStations = "Today "+ format+ ", Open Stations Are: ";
	for (String i : stations) {
		availableStations = availableStations+ i +", "; 
}
	System.out.print("Welcome To Rafford New York Private Train Station LLC. \n"); 
	System.out.print(availableStations+"\n"); 
	System.out.println("Which Of The Open Station Would You Like To Depart From?");
}	

public void departFrom() {
	String input = read.nextLine();
	for(String i : stations) {
		if(i.equalsIgnoreCase(input)) {
			departStation = i;
			System.out.println("You Will Depart From "+ i + " Station");
		}
	}
	
}

public void arriveTo() {//Method to confirm the station user wants to arrive to
	boolean found = false;
	System.out.println("Which Of The Open Station Would You Like To Arrive At?");
	String input = read.nextLine();
	while(input.equalsIgnoreCase(departStation)) {
		System.out.println("You Can Not Depart and Arrive At The Same Station!!");
		System.out.println("Try A Different Open Station, Which Of The Open Station Would You Like To Arrive At?");
		 input = read.nextLine();
	}
	for(String i : stations) {
		if(i.equalsIgnoreCase(input)) {
			arriveStation = i;
			found = true;
			System.out.println("You Will Depart From "+ departStation + " And Arrive At "+ arriveStation);
			System.out.println("Type \"yes\" to proceed to view your ticket");
			System.out.println("Type \"no\" to go back");
			input = read.nextLine();
			if(!input.equalsIgnoreCase("yes")) {
				startApplication();
			}
		}
	}
	if(found == false) {
		System.out.println("You Have Type A Station that is Not Open Today");
		System.out.println("Thank You For Visiting Rafford New York Private Train Station LLC. Come Back Tomorrow And Try Again!");
	}
	
}

public void ticketPrice() {//Method to calculate price 
	Random random = new Random();
  int hold = 50 + random.nextInt(120);;
  System.out.println("Your Train Ticket Price is $"+hold+". Departing From "+departStation +" And Arriving At " +arriveStation);
  System.out.println("Type \"yes\" to purchase your Train Ticket for $"+hold);
  System.out.println("Type \"no\" To Not Purchase Anything");
 String input = read.nextLine();
	if(!input.equalsIgnoreCase("yes")) {
		System.out.println("Thank You For Visiting Rafford New York Private Train Station LLC. Thank You For Your Time!");
	}
	else if (input.equalsIgnoreCase("yes")) {
		System.out.println("You Have Purchased A Train Ticket For $"+ hold+". Departing From "+departStation+" And Arriving At " +arriveStation);
		System.out.println("Thank You For Visiting Rafford New York Private Train Station LLC. Thank You For Your Time!");
	}
		
}
}


