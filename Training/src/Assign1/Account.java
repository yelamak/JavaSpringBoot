package Assign1;

public class Account {

	private int accountno;
	private String customername;
	private int balance;
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Account(int accountno, String customername, int balance) {
		super();
		this.accountno = accountno;
		this.customername = customername;
		this.balance = balance;
	}
	
}
