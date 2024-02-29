package com.cjc.admin;

import java.util.Scanner;

import com.cjc.service.RBI;
import com.cjc.serviceImpl.ICICI;

public class BankApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		RBI rbi = new ICICI();

		boolean flag = true;

		while (flag) {
			System.out.println("************Welcome To The ICICI Bank App****************");
System.out.println("************Welcome To The ICICI Bank App****************");
	
			System.out.println("Enter 1 For Create Account");
			System.out.println("Enter 2 For View Account Details");
			System.out.println("Enter 3 For WithDrawl Money");
			System.out.println("Enter 4 For Deposite Money");
			System.out.println("Enter 5 For View Account Balance");
			System.out.println("Enter 6 For View All Account Data");
			System.out.println("Enter 7 For Update Account Details");
			System.out.println("Enter 8 For Delete Account");
			System.out.println("Enter 9 For Delete All Account");
			System.out.println("Enter 10 For Exit From App");
			System.out.println("*************************************************");
System.out.println("************Welcome To The ICICI Bank App****************");
	
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				rbi.createAccount();
				break;
			case 2:
				rbi.viewDetails();
				break;

			case 3:
				rbi.withDrawlMoney();
				break;

			case 4:
				rbi.depositeMoney();
				break;

			case 5:
				rbi.viewBalance();
				break;

			case 6:
				rbi.viewAllData();
				break;

			case 7:
				rbi.updateDetails();
				break;

			case 8:
				rbi.deleteAccount();
				break;

			case 9:
				rbi.deleteAllAccount();
				break;

			case 10:
				flag = false;
				System.out.println("Thank You For banking With Us.......");
				break;

			default:
				System.err.println("Wrong Input Provided.......");
				break;
			}

		}

	}

}
