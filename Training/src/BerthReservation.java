import java.util.Scanner;

public class BerthReservation implements Runnable {

	private int Available=10;
	private int requested;
	@Override
	public synchronized void run() {
		System.out.println("");
		System.out.println("Welcome to ticket booking "+Thread.currentThread().getName());
		Scanner sc =new Scanner(System.in);
		
		int flag=1;
		if(Available>0)
		{
			System.out.println("No of available seats are "+Available);
			System.out.println("Please enter number of seats to be reserved");
			do {
			 requested= sc.nextInt();
			 if(requested>Available && requested>0) {
				 System.out.println("You have requested more number of seats than available seats.Available seats are "+Available+".");
				 System.out.println("Re enter no of seats.If you want to quit from reservation please enter 0");
				 flag=0;
			 }else
			 {
				 Available -=requested;
				 if(requested==0)
					 System.out.println("You have been quited from booking option");
				 else
					 System.out.println(requested+" seats are booked");
				 flag=1;
			 }
			}while(flag==0);
		}
		else{
			System.out.println("Sorry seats are not available");
		}
		sc.close();
	}
	
	

}
