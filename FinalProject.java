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