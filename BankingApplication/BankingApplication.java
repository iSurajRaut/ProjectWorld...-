package Projects;

import java.util.Scanner;

public class BankingApplication 
{
			int balence;
			int PriviousTransaction;
			String cname;
			int cid;
			BankingApplication (String customerName,int customerId){
				cname=customerName;
				cid=customerId;
			}
public static void main(String[] args) {
		BankingApplication obj = new BankingApplication("Nishant_Mahalle",12345);
		obj.showMenu();
	}			
		public void deposit(int amount) {
			if(amount !=0) 	{
				balence=balence+amount;
			}
		}
		public void withdrawal(int amount) {
			if(amount !=0)	{
				balence=balence-amount;
				PriviousTransaction=-amount;
				System.out.println("Money has been withdrawal Successfull");
			}
		}
		public void getPriviousTransaction() {
			if (PriviousTransaction>0) {
				System.out.println("Deposited : "+PriviousTransaction);
			} 
			else if(PriviousTransaction<0) {
				System.out.println("Withdraw : "+Math.abs(PriviousTransaction));
			}
			else{
				System.out.println("No transaction occured");
			}

		}
		public void showMenu() {
			char option ='\0';
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Wellcome       : "+cname);
			System.out.println("Show your ID   : "+cid);
			System.out.println("_______________________________");
			
			System.out.println("'A': Check Your Account Balence");
			System.out.println("'B': Deposite");
			System.out.println("'C': Withdraw");
			System.out.println("'D': Privious Transaction");
			System.out.println("'E': Exit the System");
			do {
				System.out.println("_______________________________");
				System.out.println("Enter your option...?");
				option = scanner.next().charAt(0);
						
				System.out.println("\n");
				
				switch(option) {
				case 'A':
					System.out.println("Your Account Balence is : "+balence);
					System.out.println("\n");
					break;
					
				case 'B':					
					System.out.println("Enter Amount You Want To Deposit?");					
					int amount = scanner.nextInt();
					deposit(amount);
					System.out.println("Your Amount Has Been Deposited successfully");					
					break;
				case 'C':					
					System.out.println("Enter Amount To Withdraw");
					int amount1 = scanner.nextInt();
					withdrawal(amount1);					
					break;
				case 'D':					
					getPriviousTransaction();
					break;
				case 'E':
					System.out.println("༼ つ ◕_◕ ༽つ");
					default:
					System.out.println("");
					break;
				}
			}
			while(option !='E');
			System.out.println("Thank You for Visiting Our Bank Sir ");
		}
	}