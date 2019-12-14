//initial file
/*
Objective: Create an InventoryManagementSystem(IMS).The IMS will contain a catalog of items(stationery Items)that can be managed, viewed, and purchased. 



Command line Menu:
Main Menu:
1)Admin
2)User
3)Exit
User could select an option from this list. If user select 1, it should display Admin Menu with the following options:

Admin Menu:
1)Add new item
2)Search and update item
3)Search and delete
Implements these options for admin personnel.In main menu, if user select 2 from the Main Menu it should display user menu. 

User menu should contains the following options:
User Menu:
1)Search item
2)Place order(or purchase item)
Implement these options for user activities.
*/

import java.util.Scanner;

public class FinalProject{

	private Scanner input = new Scanner(System.in);
	private Item[] items = new Item[100];

	public static void main(String[] args){
		FinalProject fp = new FinalProject();
	}

	public void mainMenu(){
		//display menu and ask for user selection (Validate)

		boolean looper = true;

		String userName;
		String userPassword;
		String adminName = "admin";
		String adminPassword = "admin123";

		while(looper){
			int choice = 0;
			System.out.println("Main Menu \n");
			System.out.println("\t1) Admin");
			System.out.println("\t2) User");
			System.out.println("\t3) Exit");
			choice = input.nextInt();

			while(choice != 1 && choice != 2 && choice != 3){
				System.out.println("Invalid input. Please enter 1,2 or 3: ");
				choice = input.nextInt();
			}

			switch(choice){
				case 1:
					input.nextLine();
					System.out.println("Enter Admin User Name: ");
					userName = input.nextLine();
					System.out.println("Enter Admin Password: ");
					userPassword = input.nextLine();

					if(userName == adminName && userPassword == adminPassword){
						adminMenu();
					}else{
						System.out.println("Username or Password incorrect.");
					}

					break;

				case 2:
					userMenu();
					break;

				case 3:
					looper = false;

			}
		}

	}

	public void adminMenu(){
		////display menu and ask for user selection (Validate)

		System.out.println("Admin Menu \n");
		System.out.println("\t1) Add new Item");
		System.out.println("\t2) Search and update item");
		System.out.println("\t3) Search and delete item");

		int choice = input.nextInt()

		while(choice != 1 && choice != 2 && choice != 3){
			System.out.println("Invalid input. Please enter 1,2 or 3: ");
			choice = input.nextInt();
		}

		itemID = 0;

		switch(choice){
			case 1:
				addItem();
				break;

			case 2:
				System.out.println("Enter the Item ID: ");
				itemID = input.nextInt();
				updateItem(itemID);
				System.out.println("Item with Item ID (" + itemID + ") updated");
				break;

			case 3:
				System.out.println("Enter the Item ID: ");
				itemID = input.nextInt();
				deleteItem(itemID);
				System.out.println("Item with Item ID (" + itemID + ") deleted");
				break;
		}
	}

	public void userMenu(){
		//display menu and ask for user selection (Validate)
		System.out.println("User Menu \n");
		System.out.println("\t1) Search item");
		System.out.println("\t2) Place order(or purchase item)");

		int choice = input.nextInt()

		while(choice != 1 && choice != 2){
			System.out.println("Invalid input. Please enter 1,2 or 3: ");
			choice = input.nextInt();
		}

		int itemID = 0;

		switch(choice){
			case 1: 
				int itemSearch = searchForItem();

				if(itemSearch == -1){
					System.out.println("No Item found");
				}else{
					System.out.println("Your Item: " + items[itemSearch]);
				}

			case 2: 
				System.out.println("Enter Item ID to purchase item");
				itemID = input.nextInt();
				purchaseItem(itemID);

			default:
				break;
		}
	}

	private void displayAllItems(){

	}

	public int searchForItem(){

	}

	private void deleteItem(int index){

	}

	private void updateItem(int index){

	}

	private void addItem(){

	}

	private void purchaseItem(int index){

	}
}

class Item {

	private String id;
	private String name;
	private double price;
	private int quantity;

	//add constructors
	public Item(String id, String name, double price, int quantity){
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	//add get and set methods
	//getters
	public String getID(){
		return id;
	}

	public String getName(){
		return name;
	}

	public double getPrice(){
		return price;
	}

	public int getQuantity(){
		return quantity;
	}

	//setters
	public void setID(String id){
		this.id = id;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

}