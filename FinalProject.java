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
			System.out.println("1. Admin");
			System.out.println("2. User");
			System.out.println("3. Exit");
			System.out.println("Please enter your choice: ");
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
	}

	public void userMenu(){
		//display menu and ask for user selection (Validate)
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
	//add get and set methods
}