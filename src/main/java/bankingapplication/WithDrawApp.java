package bankingapplication;

import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.banking.bean.Transaction;
import com.banking.dao.AccountDao;
import com.banking.dao.TransactionDao;
import com.banking.dao.imp.AccountDaoImpl;
import com.banking.dao.imp.TransactionDaoImpl;

public class WithDrawApp {

	public static void main(String[] args) {
		ApplicationContext ap=new ClassPathXmlApplicationContext("context.xml");
		 AccountDao aco=ap.getBean("accountDaoImpl",AccountDaoImpl.class);
		 TransactionDao tdo=ap.getBean("transactionDaoImpl",TransactionDaoImpl.class);
		 Transaction td=ap.getBean("transaction",Transaction.class);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter accountnumber");
		int acno=sc.nextInt();
		int row = aco.checkAccountNo(acno);
		if(row==1)
		{
			System.out.println("enter amount to withdraw");
			double amount=sc.nextDouble();
			td.setAccountacno(acno);
			td.setAmount(amount);
			td.setTransactiontype("W");
			td.setDateoftransaction(new Date());
			td.setDescription(null);
			double balance=aco.getBalance(acno);
			if(amount<balance) {
			balance=balance-amount;
			td.setBalance(balance);
			int row1 = tdo.insert(td);
			int row2 = aco.updateBalance(acno, balance);
			if(row1>0 && row2>0)
				System.out.println( amount +"rs withdrawn and your current balance is"+balance);
			else
				System.out.println("something went wrong");
			}
			else
				System.out.println("insufficent balance");
		}
		else
			System.out.println("account not found");

	}

}
