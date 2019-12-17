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
	private static Item[] items = new Item[100];
	private int counter = 9;

	public static void main(String[] args){


		FinalProject fp = new FinalProject();
		//public Item(int id, String name, double price, int quantity)
		items[0] = new Item(1, "Car", 23, 23);
		items[1] = new Item(2, "Toy", 11, 11);
		items[2] = new Item(3, "Ball", 12, 12);
		items[3] = new Item(4, "Bat", 14, 13);
		items[4] = new Item(5, "Camera", 16, 16);
		items[5] = new Item(6, "Monitor", 17, 17);
		items[6] = new Item(7, "Keyboard", 18, 18);
		items[7] = new Item(8, "Mouse", 19, 19);
		items[8] = new Item(9, "Headphone", 20, 20);
		items[9] = new Item(10, "Mic", 21, 21);
		fp.mainMenu();
	}

	public void mainMenu(){
		//display menu and ask for user selection (Validate)

		boolean looper = true;

		String userName = "";
		String userPassword = "";
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
					System.out.println("Enter Admin Username: ");
					userName = input.nextLine();
					System.out.println("Enter Password for " + userName + ": ");
					userPassword = input.nextLine();

					if(userName.equals(adminName) && userPassword.equals(adminPassword)){
						adminMenu();
					}else{
						System.out.println("Username or Password is incorrect");
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
		System.out.println("\t1) Display all items");
		System.out.println("\t2) Add new Item");
		System.out.println("\t3) Search and update item");
		System.out.println("\t4) Search and delete item");

		int choice = input.nextInt();

		while(choice != 1 && choice != 2 && choice != 3 && choice != 4){
			System.out.println("Invalid input. Please enter 1,2 or 3: ");
			choice = input.nextInt();
		}

		int itemID = -1;

		switch(choice){
			case 1:
				displayAllItems();
				break;

			case 2:
				addItem();
				break;

			case 3:
				updateItem(searchForItem());
				break;

			case 4:
				deleteItem(searchForItem());
				System.out.println("\nItem deleted\n");
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

		

		switch(choice){
			case 1: 
				int itemCounter = searchForItem();
				if(itemCounter == -1){
					System.out.println("\nItem not found in inventory\n");
				}
				break;
			case 2: 
				purchaseItem(searchForItem());
				break;
		}
	}

	private void displayAllItems(){
		if(counter == 0){
			System.out.println("\nInventory is Empty\n");
		}else{
			for(int i = 0; i < counter; i++){
				System.out.println("ID: " + items[i].getID() + "\t" + "Name: " + items[i].getName()  + "\t" + "Price: " + items[i].getPrice()  + "\t" + "Quantity: " + items[i].getQuantity());
			}
		}
	}

	public int searchForItem(){
		int productID;

		if(counter==0){
			System.out.println("\nInventory is Empty\n");
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

		System.out.println("ID: " + items[itemCounter].getID() + "\t" + "Name: " + items[itemCounter].getName()  + "\t" + "Price: " + items[itemCounter].getPrice()  + "\t" + "Quantity: " + items[itemCounter].getQuantity());
		return itemCounter;
	}

	private void deleteItem(int itemCounter){
		if(counter==0){
			System.out.println("\nInventory is Empty\n");
		}
		
		Item[] temp = items;
		
		if(itemCounter >= counter){
			System.out.println("\nItem not found in inventory\n");
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
			System.out.println("\nInventory is Empty\n");
		}else if(itemCounter > counter){
			System.out.println("\nItem not found in inventory\n");
		}else{
			input.nextLine();

			System.out.println("New Product ID: ");
			updatedID = input.nextInt();
			input.nextLine();

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

			System.out.println("\nItem updated\n");
		}

	}

	private void addItem(){

		input.nextLine();

		System.out.println("Product Name: ");
		String newName = input.nextLine();
		input.nextLine();

		System.out.println("Product ID: ");
		int newID = input.nextInt();


		System.out.println("Product Price: ");
		double newPrice = input.nextDouble();

		System.out.println("Product Quantity: ");
		int newQuantity = input.nextInt();



		items[counter] = new Item(newID, newName, newPrice, newQuantity);

		counter++;

		System.out.println("\nItem added\n");

	}

	private void purchaseItem(int itemCounter){
		int purchaseQuantity;
		int itemQuantity;
		double cost = 0;
		double tax = 0.07;
		double taxCost = 0;
		double totalCost = 0;
		if(itemCounter > counter){
			System.out.println("\nItem not found in inventory\n");
		}else{
			System.out.println("Specify quantity for purchase of " + items[itemCounter].getName() + " :");
			purchaseQuantity = input.nextInt();

			while(purchaseQuantity <= 0){
				System.out.println("Please specify a quantity greater than 0");
				purchaseQuantity = input.nextInt();
			}

			itemQuantity = items[itemCounter].getQuantity();

			if(itemQuantity >= purchaseQuantity){
				items[itemCounter].setQuantity(itemQuantity - purchaseQuantity);
				cost = purchaseQuantity * items[itemCounter].getPrice();
				taxCost = cost*tax;
				totalCost = cost + taxCost;
				System.out.println("\nYour total cost for this transaction after tax: " + totalCost + "\n");
			}else{
				System.out.println("\nItem not available or purchase quantity too high\n");
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