package Assign1;

import java.util.Scanner;

public class AccountApplication{

	
	public static void main(String[] args) {
		AccountOperation ac=new AccountOperation();
		String input;
		String pass;
		
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("Press w: withdraw,c: create account,d: deposite ,a:check balance,v: view accounts ,x: exit");
			 input=sc.next();
			switch(input) {
			case "w" : 	ac.withdraw();
						break;
			case "c" : ac.createAccount();
						break;
			case "d" :  ac.deposite();
						break;
			case "a" : ac.viewbalance();
						break;
			case "v" :  System.out.println("please enter admin password to view");
						pass=sc.next();
						if(pass.equals("admin123"))
							ac.displayAllAccounts();
						else {
							System.out.println("wrong password! your have no rights to use this option");
							System.out.println("");
						}
						break;
			case "x" : break;
			default : System.out.println("not a valid input");
			}
		}while(!input.equals("x"));
		System.out.println("You have been exited from our application");
		sc.close();
	}
}
