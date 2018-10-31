
public class ReservationApplication {

	public static void main(String[] args) {
		BerthReservation br=new BerthReservation();
		Thread t1=new Thread(br);
		Thread t2=new Thread(br);
		Thread t3=new Thread(br);
		t1.setName("manoj");
		t2.setName("kumar");
		t3.setName("yelamak");
		t1.start();
		t2.start();
		t3.start();
	}

}
