//Name: Alexander Augustin
//
//Section: 165B
//Project Number: 3
//Brief description of file contents: Currency Exchange

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Scanner;

public class CurrencyExchange {

	private static double balance = 0;

	// Get the current balance of the account.
	public static double getBalance() {
		return balance;
	}

	// Update the balance of current account, will do a roundup to 2 significant digits.
	// If update succeeds, it will return true. If update fails, it will return false.
	private static boolean updateBalance(double newBalance){
		balance = Math.round(newBalance * 100) / 100.0;
		if (balance >= 0){
			return true;
		}
		else
			return false;
	}


	// Main Method
	public static void main(String[] args){

		int mainMenuChoice;
		double amount = 0;
		int currencyType = 0;

		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to Currency Exchange 2.0 \n\nCurrent rates are as follows:\n");

		printConversionTable();


		do {
			mainMenuChoice = mainMenuOptionSelector(input);

			// If the client wants to see his or her balance.
			if (mainMenuChoice == 1){
				System.out.println("Your current balance is: " + getBalance() + "\n");
			}

			// If the client wants to make a deposit.
			else if (mainMenuChoice == 2){

				//convertCurrency(amount, currencyType, true);

				// Call CURRENCY MENU OPTION SELECTOR 2
				currencyType = currencyMenuOptionSelector(input);

				System.out.println("Please enter the deposit amount: ");
				amount = input.nextDouble();

				System.out.println(logTransaction(amount, currencyType, true));
				deposit(amount, currencyType);
				//System.out.println(logTransaction(amount, currencyType, true));

			}

			// If the client wants to make a withdraw.
			else if (mainMenuChoice == 3){

				// Call CURRENCY MENU OPTION SELECTOR 3
				currencyType = currencyMenuOptionSelector(input);

				System.out.println("Please enter the withdraw amount: ");
				amount = input.nextDouble();

				System.out.println(logTransaction(amount, currencyType, false));
				withdraw (amount, currencyType);

			}

			else if (mainMenuChoice == 4){
				System.out.print("Your remaining balance is " + getBalance()  + " U.S. Dollars \n" + "Goodbye");
				 break;
			 }

		} while (true);

	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static String type(int currencyType){

		String type = "";

		switch (currencyType){
		case 1 : type = "U.S. Dollars"; break;
		case 2 : type = "Euros"; break;
		case 3 : type = "British Pounds"; break;
		case 4 : type = "Indian Rupees"; break;
		case 5 : type = "Australian Dollars"; break;
		case 6 : type = "Canadian Dollars"; break;
		case 7 : type = "Singapore Dollars"; break;
		case 8 : type = "Swiss Francs"; break;
		case 9 : type = "Malaysian Ringgits"; break;
		case 10: type = "Japanese Yen"; break;
		case 11: type = "Chinese Yuan Renminbi"; break;
		}

		return type;

	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// printConversionTable method
	private static void printConversionTable(){

		// Current rates
		System.out.println("1 -  U.S. Dollar - 1.00 \n"
				+ "2 - Euro - 0.89 \n"
				+ "3 - British Pound - 0.78 \n"
				+ "4 - Indian Rupee - 66.53 \n"
				+ "5 - Australian Dollar - 1.31 \n"
				+ "6 - Canadian Dollar - 1.31 \n"
				+ "7 - Singapore Dollar - 1.37 \n"
				+ "8 - Swiss Franc - 0.97 \n"
				+ "9 - Malaysian Ringgit - 4.12 \n"
				+ "10 - Japanese Yen - 101.64 \n"
				+ "11 - Chinese Yuan Renminbi - 6.67 \n");
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static int mainMenuOptionSelector(Scanner input){

		int mainMenuChoice;

		// Prompt the client to select his or her transaction.
		do {
			System.out.println("Please select an option from the list below: \n"
					+ "1. Check the balance of your account \n"
					+ "2. Make a deposit \n"
					+ "3. Withdraw an amount in a specific currency \n"
					+ "4. End your session (and withdraw all remaining currency in U.S. Dollars) \n");

			mainMenuChoice = input.nextInt();

			if (mainMenuChoice <= 0 || mainMenuChoice > 4){
				System.out.println("Input failed validation. Please try again. \n");
			}

			else {
				return mainMenuChoice;
			}

		} while (true);

	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static int currencyMenuOptionSelector(Scanner input){

		int currencyType;
		do {
			System.out.println("Please select the currency type: \n"
					+ " 1. U.S. Dollars \n"
					+ " 2. Euros \n"
					+ " 3. British Pounds \n"
					+ " 4. Indian Rupees \n"
					+ " 5. Australian Dollars \n"
					+ " 6. Canadian Dollars \n"
					+ " 7. Singapore Dollars \n"
					+ " 8. Swiss Francs \n"
					+ " 9. Malaysian Ringgits \n"
					+ "10. Japanese Yen \n"
					+ "11. Chinese Yuan Renminbi \n");

			currencyType = input.nextInt();

			if (currencyType < 1 || currencyType > 11){
				System.out.println("Input failed validation. Please try again. \n");
			}

		} while (currencyType < 1 || currencyType > 11);



		return currencyType;
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static double convertCurrency(double amount, int currencyType, boolean isConvertToUSD){

		// Conversion from a foreign currency to USD

		double newAmount = 0.0;


		if (isConvertToUSD == true){

			if (currencyType == 1){ newAmount = (amount/1.00); }

			else if  (currencyType == 2){ newAmount = (amount / 0.89); }

			else if (currencyType == 3) { newAmount = (amount / 0.78); }

			else if (currencyType == 4) { newAmount  = (amount / 66.53); }

			else if (currencyType == 5) { newAmount = (amount / 1.31); }

			else if (currencyType == 6) { newAmount = (amount / 1.31); }

			else if (currencyType == 7) { newAmount = (amount / 1.37); }

			else if (currencyType == 8) { newAmount  = (amount / 0.97); }

			else if (currencyType == 9) { newAmount = (amount / 4.12); }

			else if (currencyType == 10) { newAmount = (amount / 101.64); }

			else if (currencyType == 11) { newAmount = (amount / 6.67); }

			return newAmount;
		}



		// Conversion from USD to a foreign currency

		if (isConvertToUSD == false) {

			if (currencyType == 1){ newAmount = (amount * 1.00); }

			if  (currencyType == 2){ newAmount = (amount * 0.89); }

			else if (currencyType == 3) { newAmount = (amount * 0.78); }

			else if (currencyType == 4) { newAmount  = (amount * 66.53); }

			else if (currencyType == 5) { newAmount = (amount * 1.31); }

			else if (currencyType == 6) { newAmount = (amount * 1.31); }

			else if (currencyType == 7) { newAmount = (amount * 1.37); }

			else if (currencyType == 8) { newAmount  = (amount * 0.97); }

			else if (currencyType == 9) { newAmount = (amount * 4.12); }

			else if (currencyType == 10) { newAmount = (amount * 101.64); }

			else if (currencyType == 11) { newAmount = (amount * 6.67); }
		}
		return newAmount;

	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean deposit(double amount, int currencyType){

		double depositAmount = convertCurrency(amount, currencyType, true);

		if (amount <= 0 || currencyType < 1 || currencyType > 11){
			return false;
		}

		else {

			updateBalance(depositAmount + getBalance());

			return true;
		}

	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean withdraw(double amount, int currencyType) {

		double withdrawAmount = convertCurrency(amount, currencyType, true);

		if (withdrawAmount <= 0){
			return false;
		}

		else if (currencyType == 1 && withdrawAmount > getBalance()){
			return false;
		}

		else if (currencyType != 1 && withdrawAmount * ( 1 + 0.005) > getBalance()){
			return false;
		}

		else if (currencyType == 1){
			updateBalance(getBalance() - withdrawAmount);
			return true;
		}
		else if (currencyType != 1){
			updateBalance(getBalance() - withdrawAmount * ( 1 + 0.005));
			return true;
		}
		return true;
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static String logTransaction(double amount, int currencyType, boolean isDeposit){


		String log = "";

		if (isDeposit == true){

			if (amount <= 0){
				log ="Logging Error \n";
			}
			else {
				log = "You successfully deposited " + amount  + " " + type(currencyType) + "\n";
			}

		}

		else if (isDeposit == false){

			if (amount <= 0 || amount > getBalance()){

				log = "Error: Insufficient funds. \n"
						+ "Logging Error \n";
			}

			else {
				log = "You successfully withdrew " + amount  + " " + type(currencyType) + "\n";
			}
		}

		return log;
	}



}
