package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.security.auth.login.AccountException;

import model.entities.Account;
import model.entities.Client;
import model.exceptions.ClientException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		int mainMenuOption = 0;
		
		List<Account> accountList = new ArrayList<>();
		List<Client> clientList = new ArrayList<>();
		
		while(mainMenuOption != 5) {
			Menu.mainMenu();
			mainMenuOption = scan.nextInt();
			System.out.println();
			
			switch(mainMenuOption) {
				case 1:
					//REGISTER OPERATIONS
					try {
						System.out.println("Enter account data");
						int number = Menu.generateIDNumber();
						System.out.println("Number: " + number);
						System.out.print("Holder: ");
						scan.nextLine();
						String name = scan.nextLine();
						System.out.print("Initial balance: ");
						double balance = scan.nextDouble();
						System.out.print("Enter the type of client (V --> VIP / S --> Standard): ");
						char classification = scan.next().charAt(0);
						System.out.println();
						double withdrawLimit = 0.0;
						if (classification == 'V') {
							withdrawLimit = 100000.00;
						}
						else if (classification == 'S') {
							withdrawLimit = 3000.00;
						}
						Account account = new Account(number, name, balance, withdrawLimit);
						Client client = new Client(name, classification, Menu.generateCode(10));
						accountList.add(account);
						clientList.add(client);
					}
					catch (ClientException e) {
						System.out.println("ERROR: " + e.getMessage());
						System.out.println();
					}
					break;
					
				case 2:
					//DEPOSIT OPERATIONS
					try {
						if (accountList.isEmpty()) {
							throw new AccountException("YOU MUST REGISTER AN ACCOUNT IN ORDER TO MAKE A DEPOSIT");
						}
						
						System.out.print("Choose account by number: ");
						int choosedAccountNumber = scan.nextInt();
						
						for (int i = 0; i < accountList.size(); i++) {
							if (choosedAccountNumber == accountList.get(i).getNumber()) {
								System.out.println("Current account balance: " + accountList.get(i).getBalance());
								System.out.println("Current account holder: " + accountList.get(i).getHolder());
								System.out.println("Current account withdraw Limit: " + accountList.get(i).getWithdrawLimit());
								System.out.println();
							}
						}
						
						System.out.print("Enter deposit value: ");
						double depositValue = scan.nextDouble();
						
						for (int i = 0; i < accountList.size(); i++) {
							if (choosedAccountNumber == accountList.get(i).getNumber()) {
								accountList.get(i).deposit(depositValue);
								System.out.println("Updated balance: " + accountList.get(i).getBalance());
								System.out.println();
							}
						}
					}
					catch (AccountException e) {
						System.out.println("ERROR: " + e.getMessage());
						System.out.println();
					}
					break;
					
				case 3:
					//WITHDRAW OPERATIONS
					try {
						if (accountList.isEmpty()) {
							throw new AccountException("YOU MUST REGISTER AN ACCOUNT IN ORDER TO MAKE A DEPOSIT");
						}
						System.out.print("Choose account by number: ");
						int choosedAccountNumber = scan.nextInt();
						
						for (int i = 0; i < accountList.size(); i++) {
							if (choosedAccountNumber == accountList.get(i).getNumber()) {
								System.out.println("Current account balance: " + accountList.get(i).getBalance());
								System.out.println("Current account holder: " + accountList.get(i).getHolder());
								System.out.println("Current account withdraw Limit: " + accountList.get(i).getWithdrawLimit());
								System.out.println();
							}
						}
						System.out.print("Enter withdraw value: ");
						double withdrawValue = scan.nextDouble();
						
						for (int i = 0; i < accountList.size(); i++) {
							if (choosedAccountNumber == accountList.get(i).getNumber()) {
								accountList.get(i).withdraw(withdrawValue);
								System.out.println("Updated balance: " + accountList.get(i).getBalance());
								System.out.println();
							}
						}
					}
					catch (AccountException e) {
						System.out.println("ERROR: " + e.getMessage());
						System.out.println();
					}
					break;
					
				case 4:
					//CHECK ACCOUNT DATA
					System.out.print("Choose account by number: ");
					int choosedAccountNumber = scan.nextInt();
					
					for (int i = 0; i < accountList.size(); i++) {
						if (choosedAccountNumber == accountList.get(i).getNumber()) {
							System.out.println("Current account holder: " + accountList.get(i).getHolder());
							System.out.println("Current account code: " + clientList.get(i).getCode());
							System.out.println("Current account number: " + accountList.get(i).getNumber());	
							System.out.println("Current account balance: " + accountList.get(i).getBalance());
							System.out.println("Current account withdraw Limit: " + accountList.get(i).getWithdrawLimit());
							System.out.println();
						}
					}
					break;
			}
		}
		
		
		scan.close();
	}

}
