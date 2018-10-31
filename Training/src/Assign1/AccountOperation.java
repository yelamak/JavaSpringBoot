package Assign1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountOperation {
	private int currentAccountNo=105;
	List<Account> ac=new ArrayList<>();
	Scanner sc=new Scanner(System.in);
	public AccountOperation() {
		
		ac.add(new Account(101,"manoj",5000));
		ac.add(new Account(102,"kumar",5000));
		ac.add(new Account(103,"yelamak",5000));
		ac.add(new Account(104,"akhil",5000));
		ac.add(new Account(105,"mani",5000));	
	}
	
	public void deposite() {
		boolean flag=false;
		int Accountno;
		int amount;
		System.out.println("enter account number and amount you want to deposite");
			 Accountno=sc.nextInt();
			 amount=sc.nextInt();
			 
			 for (Account account : ac) {
					if(account.getAccountno()==Accountno) {
						System.out.println("your name is "+ account.getCustomername());
						System.out.println("press y if it is correct");
						String input=sc.next();
						if(input.equals("y")) {
							amount +=account.getBalance();
							account.setBalance(amount);
							System.out.println("Money has been depoisted and your balance is "+account.getBalance());
						}
						else
							System.out.println("Thanks for confirming its not your account");
						flag=true;
					}
					
				}
		
			if(!flag) {
				 try {
					throw new AccountNotFoundException();
				} catch (AccountNotFoundException e) {
					System.out.println(e+"\n");
				}
				
			}
			
		
	}
	
	public void withdraw() {
		boolean flag=false;
		int Accountno;
		int amount;
		System.out.println("enter account number and amount you want to withdraw");
			 Accountno=sc.nextInt();
			 amount=sc.nextInt();
			 try {
			 for (Account account : ac) {
					if(account.getAccountno()==Accountno) {
						flag=true;
						System.out.println("your name is "+ account.getCustomername());
						System.out.println("press y if it is correct");
						String input=sc.next();
						if(input.equals("y")) {
							if(account.getBalance()>=amount) {
							amount =account.getBalance()-amount;
							account.setBalance(amount);
							System.out.println("Money has been withdrawn and your balance is "+account.getBalance()+"\n");
						}
							else
								throw new InsufficentBalanceException();
								
							
						}
						else {
							System.out.println("Thanks for confirming that is not your account");
							
						}
						
					}
					
						
					}
			 if(!flag) {
				 
					throw new AccountNotFoundException();
				} 
			 }
			 catch (InsufficentBalanceException e) {
					System.out.println(e+"\n");
				}
			 catch (AccountNotFoundException e) {
					System.out.println(e+"\n");
				}
			
				
			
			
	}
	
	public void viewbalance() {
		boolean flag=false;
		int Accountno;
		System.out.println("enter account number");
			 Accountno=sc.nextInt();
			 try {
			  for (Account account : ac) {
					if(account.getAccountno()==Accountno) {
						System.out.println("your name is "+ account.getCustomername());
						System.out.println("press y if it is correct");
						String input=sc.next();
						if(input.equals("y")) {
							
							System.out.println("Your balance is "+account.getBalance());
						}
						else
							System.out.println("Thanks for confirming its not your account");
						flag=true;
					}
					
				}
		
			if(!flag) {
				
					throw new AccountNotFoundException();
				} 
				
			}
	
			 catch (AccountNotFoundException e) {
					System.out.println(e+"\n");
				}
	}
	
	public void createAccount() {
		System.out.println("Please enter name and balance you want to deposite");
		String tempName=sc.next();
		int tempBalance=sc.nextInt();
		ac.add(new Account(++currentAccountNo,tempName,tempBalance));
		System.out.println("your account is created successfully and your account number is: "+currentAccountNo);
	}
	
	public void displayAllAccounts() {
		for (Account account : ac) {
			System.out.println(account.getAccountno() +" "+account.getBalance()+" "+account.getCustomername());
		}
		System.out.println("");
	}

}
