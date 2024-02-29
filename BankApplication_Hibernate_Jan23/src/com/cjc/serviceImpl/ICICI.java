package com.cjc.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.cjc.configue.HibernateUtil;
import com.cjc.model.Account;
import com.cjc.service.RBI;

public class ICICI implements RBI {

	Scanner sc = new Scanner(System.in);

	@Override
	public void createAccount() {

		Account ac = new Account();
		System.out.println("Enter Account Holder Name");
		ac.setAcName(sc.next() + sc.nextLine());
		System.out.println("Enter Account Holder Address");
		ac.setAcAddress(sc.next() + sc.nextLine());
		System.out.println("Enter Account Holder Mobile NO");
		ac.setMobileNO(sc.nextLong());
		System.out.println("Enter Account Holder AdharNo");
		ac.setAdharNo(sc.nextLong());
		System.out.println("Enter Account Holder PanNO");
		ac.setPanNO(sc.next());
		System.out.println("Enter Account Holder Balance");
		ac.setBalance(sc.nextDouble());
		System.out.println("Enter Account Holder Age");
		ac.setAge(sc.nextInt());
		System.out.println("Enter Account Holder Gender");
		ac.setGender(sc.next());

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.save(ac);
		session.beginTransaction().commit();
		System.out.println("**********Account created SuccessFully**********");
	}

	@Override
	public void viewDetails() {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		System.out.println("Enter Account Holder No To View Details");
		int acno = sc.nextInt();
		Account ac = session.get(Account.class, acno);

		if (ac != null) {
			System.out.println("*******************Account Details**************");
			System.out.println("Account Holder No :" + ac.getAcNo());
			System.out.println("Account Holder Name :" + ac.getAcName());
			System.out.println("Account Holder Address :" + ac.getAcAddress());
			System.out.println("Account Holder MobileNo :" + ac.getMobileNO());
			System.out.println("Account Holder AdharNo :" + ac.getAdharNo());
			System.out.println("Account Holder PanNo :" + ac.getPanNO());
			System.out.println("Account Holder Balance :" + ac.getBalance());
			System.out.println("Account Holder Gender :" + ac.getGender());
			System.out.println("Account Holder Age :" + ac.getAge());
			System.out.println("*************************************************");
		} else {
			System.err.println("Incorrect Acccount No.....");
		}

	}

	@Override
	public void withDrawlMoney() {

	}

	@Override
	public void depositeMoney() {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("Enter Account No To Deposite Money");
		int acno = sc.nextInt();
		Account ac = session.get(Account.class, acno);

		if (ac != null) {
			System.out.println("Enter Amount To Deposite Money");
			int uamt = sc.nextInt();
			if (uamt >= 100) {
				double newbal = ac.getBalance() + uamt;
				ac.setBalance(newbal);
				session.update(ac);
				session.beginTransaction().commit();
				System.out.println("Amount Deposited SuccessFully :" + uamt);
			} else {
				System.out.println("Provided Amount is Below than 100 Rs.");
			}
		} else {
			System.err.println("Incoorect Account No.....");
		}

	}

	@Override
	public void viewBalance() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDetails() {
		
		//switch cases
		

	}

	@SuppressWarnings("deprecation")
	@Override
	public void viewAllData() {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		Query query = session.createSQLQuery("select * from account_details").addEntity(Account.class);

		List<Account> list = query.getResultList();

		for (Account ac : list) {
			System.out.println("*******************Account Details**************");
			System.out.println("Account Holder No :" + ac.getAcNo());
			System.out.println("Account Holder Name :" + ac.getAcName());
			System.out.println("Account Holder Address :" + ac.getAcAddress());
			System.out.println("Account Holder MobileNo :" + ac.getMobileNO());
			System.out.println("Account Holder AdharNo :" + ac.getAdharNo());
			System.out.println("Account Holder PanNo :" + ac.getPanNO());
			System.out.println("Account Holder Balance :" + ac.getBalance());
			System.out.println("Account Holder Gender :" + ac.getGender());
			System.out.println("Account Holder Age :" + ac.getAge());
			System.out.println("*************************************************");
		}

	}

	@Override
	public void deleteAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllAccount() {
		// TODO Auto-generated method stub

	}

}
