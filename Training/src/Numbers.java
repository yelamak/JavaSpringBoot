
public class Numbers extends Thread{

	@Override
	public synchronized void run() {
		System.out.println(Thread.currentThread().getName());
		for(int i=0;i<5;i++)
			System.out.print(i+" ");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	

}
