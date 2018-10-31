
public class ThreadApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numbers num=new Numbers();
		Thread t1=new Thread(num);
		Thread t2=new Thread(num);
		Thread t3=new Thread(num);
		t1.setName("aa");
		t2.setName("bb");
		t3.setName("cc");
		t1.start();
		t2.start();
		t3.setPriority(Thread.MAX_PRIORITY);
		t3.start();
	}

}
