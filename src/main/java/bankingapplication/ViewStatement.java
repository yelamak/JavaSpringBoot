package bankingapplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.banking.bean.Transaction;
import com.banking.dao.AccountDao;
import com.banking.dao.TransactionDao;
import com.banking.dao.imp.AccountDaoImpl;
import com.banking.dao.imp.TransactionDaoImpl;

public class ViewStatement {

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
				System.out.println("Your past transactions are");
				List<Transaction> allTransactionById = tdo.getAllTransactionById(acno);
				for (Transaction transaction : allTransactionById) {
					
					System.out.println(transaction.toString());
				}
				
			}
			else
				System.out.println("account not found");



	}

}
