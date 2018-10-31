package bankingapplication;

import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.banking.bean.Account;
import com.banking.bean.Address;
import com.banking.bean.Transaction;
import com.banking.dao.AccountDao;
import com.banking.dao.AddressDao;
import com.banking.dao.TransactionDao;
import com.banking.dao.imp.AccountDaoImpl;
import com.banking.dao.imp.AddressDaoImpl;
import com.banking.dao.imp.TransactionDaoImpl;
import com.banking.services.AccountService;
/**
 * Hello world!
 *
 */
public class InsertApp 
{
	
    public static void main( String[] args )
    {
        ApplicationContext ap=new ClassPathXmlApplicationContext("context.xml");
        Account ac=ap.getBean("account",Account.class);
        Address ad=ap.getBean("address",Address.class);
        AccountDao aco=ap.getBean("accountDaoImpl",AccountDaoImpl.class);
        TransactionDao tdo=ap.getBean("transactionDaoImpl",TransactionDaoImpl.class);
		 Transaction td=ap.getBean("transaction",Transaction.class);
        AddressDao ado=ap.getBean("addressDaoImpl",AddressDaoImpl.class);
       
        AccountService as=ap.getBean("accountService",AccountService.class);
        Scanner sc=new Scanner(System.in);
	    System.out.println("enter name,city,street,depositeamount of customer");
		ac.setCustomername(sc.next());
		ad.setCity(sc.next());
		ad.setStreet(sc.next());
		double amount=sc.nextDouble();
		int idGeneration = as.IdGeneration();
		ad.setAccountacno(idGeneration);
		
		ac.setBalance(amount);
		ac.setDoc(new Date());
		ac.setAcno(idGeneration);
		ac.setAddress(ad);
		td.setAccountacno(idGeneration);
		td.setAmount(amount);
		td.setTransactiontype("D");
		td.setDateoftransaction(new Date());
		td.setDescription(null);
		int row1 = aco.insertAccount(ac);
		int row2=ado.insertAddress(ac.getAddress());
		int row3 = tdo.insert(td);
		if(row1>0 && row2>0)
			System.out.println("Account created Your account id"+idGeneration);
		else
		    System.out.println("something went wrong");
		
		sc.close();
    }
}
