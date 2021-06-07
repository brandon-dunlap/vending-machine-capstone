package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	public List<Item> itemList = new ArrayList<>(); // this stores vending machine items in array list
	private Scanner userInput = new Scanner(System.in);
	private Wallet newWallet = new Wallet();

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void getChange() {
		newWallet.giveChange(newWallet.getBalance());
	}

	public void run() {

		try {
			File vendingMachineFile = new File("vendingmachine.csv");
			Scanner vendingMachineScanner = new Scanner(vendingMachineFile);
			while (vendingMachineScanner.hasNextLine()) {
				String line = vendingMachineScanner.nextLine(); // reads from .csv
				String[] arr = line.split("\\|");
				//saving items from .csv as objects in ArrayList:
				if (arr[3].equals("Chip")) {
					Chips chips = new Chips(arr[0], arr[1], Double.parseDouble(arr[2]), arr[3]);
					itemList.add(chips);
				} else if (arr[3].equals("Candy")) {
					Candy candy = new Candy(arr[0], arr[1], Double.parseDouble(arr[2]), arr[3]);
					itemList.add(candy);
				} else if (arr[3].equals("Drink")) {
					Drink drink = new Drink(arr[0], arr[1], Double.parseDouble(arr[2]), arr[3]);
					itemList.add(drink);
				} else if (arr[3].equals("Gum")) {
					Gum gum = new Gum(arr[0], arr[1], Double.parseDouble(arr[2]), arr[3]);
					itemList.add(gum);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				for (int i = 0; i < itemList.size(); i++) {
					System.out.println(itemList.get(i));
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchaseMenu();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you, goodbye!");
				break;
			}
		}
	}

	public void purchaseMenu() {

		while (true) {
			String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			if (choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				System.out.print("Please enter 1, 2, 5, or 10: ");
				String input = userInput.nextLine();
				try {
					insertMoney(input);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println("Current Money Provided: " + newWallet.getBalance());
				Logger.writeLog("FEED MONEY: $" + input + " $" + newWallet.getBalance());

			} else if (choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
				for (int i = 0; i < itemList.size(); i++) {     //Show the list of products in stock
					System.out.println(itemList.get(i));
				}
				System.out.println(); // for space
				System.out.println("Current Money Provided: " + newWallet.getBalance());
				System.out.print("Please enter the code of the item you wish to purchase: ");
				String input = userInput.nextLine();

				boolean itemPick = false;
				// see if list of products equals itemNumber
				for (Item snacks : itemList) {
					if (input.equals((snacks.getItemNumber()))) {
						itemPick = true;
						if (snacks.isOutOfStock()) {
							System.out.println("Item is out of stock. Please choose another item.");
							return;
						}
						if (newWallet.getBalance() < snacks.getPrice()) {
							System.out.println("Not enough in balance to purchase.");
							return;
						}
						newWallet.purchases(snacks.getPrice());
						snacks.setQuantity(snacks.getQuantity() - 1);
						System.out.println(snacks.getItemName() + ": $" + snacks.getPrice() + " // Remaining balance: $" + newWallet.getBalance());
						System.out.println(snacks.message());
						Logger.writeLog(snacks.getItemName() + " " + snacks.getItemNumber() + " $" + snacks.getPrice() + " $" + newWallet.getBalance());
					}
				}
				if (!itemPick) {
					System.out.println("Not a valid item.");
				}

			} else if (choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
				getChange();
				break;
			}
		}

	}


	public void insertMoney (String money) throws FileNotFoundException {
		if (money.equals("1")) {
			newWallet.addMoney(1);
		}
		if (money.equals("2")) {
			newWallet.addMoney(2);
		}
		if (money.equals("5")) {
			newWallet.addMoney(5);
		}
		if (money.equals("10")) {
			newWallet.addMoney(10);
		}
	}


	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
