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
	private int counter = 0;

	public static void main(String[] args){
		FinalProject fp = new FinalProject();
		fp.mainMenu();
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

					adminMenu();
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

		int choice = input.nextInt();

		while(choice != 1 && choice != 2 && choice != 3){
			System.out.println("Invalid input. Please enter 1,2 or 3: ");
			choice = input.nextInt();
		}

		int itemID = -1;

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

		int choice = input.nextInt();

		while(choice != 1 && choice != 2){
			System.out.println("Invalid input. Please enter 1,2 or 3: ");
			choice = input.nextInt();
		}

		//int itemID = -1;

		switch(choice){
			case 1: 
				int itemCounter = searchForItem();
				if(itemCounter == -1){
					System.out.println("Item not found in inventory");
				}else{
					System.out.println("Your item: " + items[itemCounter].getName());
				}
				break;
			case 2: 
				//System.out.println("Enter Item ID to purchase item");
				//itemCounter = input.nextInt();
				purchaseItem(searchForItem());
				break;
		}
	}

	private void displayAllItems(){
		if(counter == 0){
			System.out.println("Inventory is Empty");
		}else{
			for(int i = 0; i < counter; i++){
				System.out.println(items[i].getName());
			}
		}
	}

	public int searchForItem(){
		int productID;

		if(counter==0){
			System.out.println("Inventory is Empty");
		}else{
			input.nextLine();
		}
		System.out.println("Enter your Product ID");
		productID = input.nextInt();
		int itemCounter = -1;
		for(int i = 0; i < counter; i++){
			if(productID == items[i].getID()){
				itemCounter = i;
			}
		}

		return itemCounter;
	}

	private void deleteItem(int itemCounter){
		if(counter==0){
			System.out.println("Inventory is Empty");
		}
		
		Item[] temp = items;
		
		if(itemCounter >= counter){
			System.out.println("Item not found in inventory");
		}else{
			for(int i = itemCounter + 1; i < temp.length; i++){
				temp[i-1] = temp[i];
			}
			counter = counter - 1;
		}

		items = temp;

	}

	private void updateItem(int itemCounter){
		int updatedID;
		String updatedName;
		double updatedPrice;
		int updatedQuantity;

		if(counter==0){
			System.out.println("Inventory is Empty");
		}else if(itemCounter > counter){
			System.out.println("Item not found in inventory");
		}else{
			input.nextLine();

			System.out.println("New Product ID: ");
			updatedID = input.nextInt();

			System.out.println("New Product Name: ");
			updatedName = input.nextLine();

			System.out.println("New Product Price: ");
			updatedPrice = input.nextDouble();

			System.out.println("New Product Quantity: ");
			updatedQuantity = input.nextInt();

			items[itemCounter].setID(updatedID);
			items[itemCounter].setName(updatedName);
			items[itemCounter].setPrice(updatedPrice);
			items[itemCounter].setQuantity(updatedQuantity);

			System.out.println("Item updated");
		}

	}

	private void addItem(){
		//int newID;
		//String newName;
		//double newPrice;
		//int newQuantity;

		input.nextLine();

		System.out.println("Product Name: ");
		String newName = input.nextLine();
		input.nextLine();

		System.out.println("Product ID: ");
		int newID = input.nextInt();
		//input.nextLine();


		//input.nextLine();

		System.out.println("Product Price: ");
		double newPrice = input.nextDouble();
		//input.nextLine();

		System.out.println("Product Quantity: ");
		int newQuantity = input.nextInt();



		items[counter] = new Item(newID, newName, newPrice, newQuantity);

		counter++;

		System.out.println("Item added");

	}

	private void purchaseItem(int itemCounter){
		int purchaseQuantity;
		int itemQuantity;
		double cost = 0;
		if(itemCounter > counter){
			System.out.println("Item not found in inventory");
		}else{
			System.out.println("Specify quantity for purchase of " + items[itemCounter].getName() + " :");
			purchaseQuantity = input.nextInt();

			while(purchaseQuantity <= 0){
				System.out.println("Please specify a quantity greater than 0");
				purchaseQuantity = input.nextInt();
			}

			itemQuantity = items[itemCounter].getQuantity();

			if(itemQuantity > purchaseQuantity && itemQuantity != 0){
				items[itemCounter].setQuantity(itemQuantity - purchaseQuantity);
				cost = purchaseQuantity * items[itemCounter].getPrice();
				System.out.println("Your total cost for this transaction: " + cost);
			}else{
				System.out.println("Item not available or purchase quantity too high");
			}
		}

	}
}

class Item {

	private int id;
	private String name;
	private double price;
	private int quantity;

	//add constructors
	public Item(int id, String name, double price, int quantity){
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	//add get and set methods
	//getters
	public int getID(){
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
	public void setID(int id){
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