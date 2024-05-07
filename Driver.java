package Driver;
import library.*;
import java.util.Scanner;

import Client.Client;

//Class representing the driver program to interact with the library system used by librarian
public class Driver {
	//Scanner object for user input
	Scanner in=new Scanner(System.in);
	//Array to store books
	Book[] booklist;
	//Array to store journals
	Journal [] journallist;
	//Array to store medias
	Media [] medialist;
	//Array to store items
	Item [] itemlist;
	//Array to store clients
	Client [] clientlist;
	//Counters for each type of items and clients
	int countBooks, countJournals, countMedias, countClient;
	//Variable to track if an item or client is found
	boolean found;
	
	//Method to display the menu options
	public void displayMenu() {
		System.out.print("What would you like to do? \n"
				+ "1. Add an item \n"
				+ "2. Delete an item \n"
				+ "3. Change information of an item \n"
				+ "4. List all items in a specific category(book, journal, or media) \n"
				+ "5. Print all items(from all categories) \n"
				+ "6. Add a client \n"
				+ "7. Edit a client \n"
				+ "8. Delete a client \n"
				+ "9. Lease an item to a client \n"
				+ "10. Return an item \n"
				+ "11. Show all items leased by a client \n"
				+ "12. Show all leased items (by all clients) \n"
				+ "13. Display the biggest book \n"
				+ "14. Make a copy of the books array \n"
				+ "Please enter your choice > ");
	}
	
	
	public void addItem() {
		//Prompt the user to select the type of item added
		System.out.print("Which kind of item would you like to add? \n"
				+ "1. Book \n"
				+ "2. Journal \n"
				+ "3. Media \n"
				+ "Please enter your choice > ");
		//Read user's choice
		int choice =in.nextInt();
		//Do-while loop as long as user's choice is not 1,2 or 3
		do {
			switch(choice) {
			//Adding a book
			case 1:
				//Prompt user for book details
				System.out.print("Enter new book's name (fill spaces with _):");
				String bname=in.next();
				System.out.print("Enter new book's author (ex: firstname_lastname):");
				String bauthor=in.next();
				System.out.print("Enter new book's year of publication:");
				int byearOfPublication=in.nextInt();
				System.out.print("Enter new book's number of pages:");
				int bnumOfPages=in.nextInt();
				
				//Create a temporary array of size one greater than book list
				Item [] temp=new Book[countBooks+1];
				//Copy all booklist iterations onto temporary array
				for (int i=0;i<countBooks;i++) {
					temp[i]=booklist[i];
				}
				//Use user input to create extra iteration made in temp array
				temp[countBooks]=new Book(bname, bauthor, byearOfPublication, bnumOfPages);
				booklist= (Book[])temp;
				//Update book count
				++countBooks;
				System.out.println("Book successfully added.");
				break;
			//Adding a journal
			case 2:
				//Prompt user for journal details
				System.out.print("Enter new journal's name (fill spaces with _): ");
				String jname=in.next();
				System.out.print("Enter new journal's author (ex: firstname_lastname):");
				String jauthor=in.next();
				System.out.print("Enter new journal's year of publication:");
				int jyearOfPublication=in.nextInt();
				System.out.print("Enter new journal's volume number:");
				int jvolumeNumber=in.nextInt();
				
				//Create a temporary array of size one greater than journal list
				temp =new Journal[countJournals+1];
				//Copu all journal list iterations onto temp array
				for (int i=0;i<countJournals;i++) {
					temp[i]=journallist[i];
				}
				//Use user input to create extra iteration made in temp array
				temp[countJournals]=new Journal(jname,jauthor,jyearOfPublication,jvolumeNumber);
				journallist=(Journal[]) temp;
				//Update journal count
				++countJournals;
				System.out.println("Journal successfully added.");
				break;
			//Add a media
			case 3:
				//Prompt user for media details
				System.out.print("Enter new media's name (fill spaces with_): ");
				String mname=in.next();
				System.out.print("Enter new media's author (ex: firstname_lastname):");
				String mauthor=in.next();
				System.out.print("Enter new media's year of publication:");
				int myearOfPublication=in.nextInt();
				System.out.print("Enter new media's type:");
				String mtype=in.next();
				
				//Create a temp array of size one greater than media list
				temp=new Media[countMedias+1];
				//Copy all media list iterations onto temp array
				for (int i=0;i<countMedias;i++) {
					temp[i]=medialist[i];
				}
				//Use user input to create extra iteration made in temp array
				temp[countMedias]=new Media(mname,mauthor,myearOfPublication,mtype);
				medialist=(Media []) temp;
				//Update media count
				++countMedias;
				System.out.println("Media successfully added.");
				break;
			//Print statement if input is out of bounds
			default:
				System.out.println("Input was outside the accepted range.");
			}
		}while (choice>3||choice<1);
	}
	public void deleteItem() {
		//Prompt the user to enter the ID of the item to delete
		System.out.print("Enter ID of item you would like to delete: ");
		String id = in.next();
		//Check if the ID belongs to a book
		if (id.startsWith("B")) {
			for (int i = 0; i<booklist.length; i++) {
				if (booklist[i].getID().equals(id)) {
					found = true;
					//Decrement the book count
					--countBooks;
					//Set the book reference to null
					booklist[i] = null;
					//Create a temporary array to hold books without the deleted one
					Book [] temp = new Book[countBooks];
					for (int j = 0; j < i; j++) {
						temp[j] = booklist[j];
					}
					
					for (int k = i; k < countBooks; k++) {
						temp[k] = booklist[k+1];
					}
					//Update book list
					booklist = temp;
					System.out.println("Book sucessfully deleted.");
				}
			}
		} 
		// Check if the ID belongs to a journal
        // Similar process as above for deleting a journal
		else if (id.startsWith("J")) {
			for (int i = 0; i<journallist.length; i++) {
				if (journallist[i].getID().equals(id)) {
					found = true;
					--countJournals;
					journallist[i] = null;
					Journal[] temp = new Journal[countJournals];
					for (int j = 0; j < i; j++) {
						temp[j] = journallist[j];
					}
					
					for (int k = i; k < countJournals; k++) {
						temp[k] = journallist[k+1];
					}
					journallist = temp;
					System.out.println("Journal successfully deleted.");
				}
			}
			
		}
		// Check if the ID belongs to a media item
        // Similar process as above for deleting a media item
		else if (id.startsWith("M")) {
			for (int i = 0; i<medialist.length; i++) {
				if (medialist[i].getID().equals(id)) {
					found = true;
					--countMedias;
					medialist[i] = null;
					Media[] temp = new Media[countMedias];
					for (int j = 0; j < i; j++) {
						temp[j] = medialist[j];
					}
					
					for (int k = i; k < countMedias; k++) {
						temp[k] = medialist[k+1];
					}
					medialist = temp;
					System.out.println("Media sucessfully deleted.");
				}
			}
			
		}
	    // If no item with the entered ID is found, display a message
		if (found == false) {
			System.out.println("No items match the entered ID.");
		}
}
	public void editItem() {
		//Prompt the user to enter the ID of the item to edit
		System.out.print("Enter ID of item you would like to edit: ");
		String id = in.next();
		
		//Check if the ID belongs to a book
		if (id.startsWith("B")) {
			//Iterate through the book list to find the item with the matching ID
			for (int i = 0; i<booklist.length; i++) {
				if (booklist[i].getID().equals(id)) {
					found = true;
					//Prompt the user to select the information to change
					System.out.print("Which information would you like to change?\n"
							+"1. Name\n"
							+"2. Author\n"
							+"3. Year of Publication\n"
							+"4. Number of Pages\n"
							+">");
					//Read user's choice
					int choice = in.nextInt();
					in.nextLine();
					
					do {
						switch (choice) {
							//Editing the name
							case 1:
								System.out.print("Type in the new name: ");
								booklist[i].setName(in.nextLine());
								break;
							//Editing the author
							case 2:
								System.out.print("Type in the new author: ");
								booklist[i].setAuthor(in.nextLine());
								break;
							//Editing the year of publication
							case 3:
								System.out.print("Type in the new year of publication: ");
								booklist[i].setYearOfPublication(in.nextInt());
								break;
							//Editing the number of pages
							case 4:
								System.out.print("Type in the new number of pages: ");
								booklist[i].setNumOfPages(in.nextInt());
								in.nextLine();
								break;
							//Default message if user input isn't 1,2,3 or 4
							default:
								System.out.print("Input out of bounds. Please try again. >");
						}
					} while (choice > 4 || choice < 1);
					
					System.out.println("Book sucessfully changed.");
				}
			}
			
		} 
        // Similar process as above for editing a journal
		else if (id.startsWith("J")) {
			for (int i = 0; i<journallist.length; i++) {
				if (journallist[i].getID() == id) {
					found = true;
					System.out.print("Which information would you like to change?\n"
							+"1. Name\n"
							+"2. Author\n"
							+"3. Year of Publication\n"
							+"4. Volume number\n"
							+">");
					int choice = in.nextInt();
					in.nextLine();
					
					do {
						switch (choice) {
							case 1:
								System.out.print("Type in the new name: ");
								journallist[i].setName(in.nextLine());
								break;
							case 2:
								System.out.print("Type in the new author: ");
								journallist[i].setAuthor(in.nextLine());
								break;
							case 3:
								System.out.print("Type in the new year of publication: ");
								journallist[i].setYearOfPublication(in.nextInt());
								break;
							case 4:
								System.out.print("Type in the new number of volume: ");
								journallist[i].setVolumeNumber(in.nextInt());
								in.nextLine();
								break;
							default:
								System.out.print("Input out of bounds. Please try again. >");
						}
					} while (choice > 4 || choice < 1);
					
					System.out.println("Journal sucessfully changed.");
				}
			}
			
		} 
        // Similar process as above for editing a media item
		else if (id.startsWith("M")) {
			for (int i = 0; i<medialist.length; i++) {
				if (medialist[i].getID() == id) {
					found = true;
					System.out.print("Which information would you like to change?\n"
							+"1. Name\n"
							+"2. Author\n"
							+"3. Year of Publication\n"
							+"4. Media Type\n"
							+">");
					int choice = in.nextInt();
					in.nextLine();
					
					do {
						switch (choice) {
							case 1:
								System.out.print("Type in the new name: ");
								medialist[i].setName(in.nextLine());
								break;
							case 2:
								System.out.print("Type in the new author: ");
								medialist[i].setAuthor(in.nextLine());
								break;
							case 3:
								System.out.print("Type in the new year of publication: ");
								medialist[i].setYearOfPublication(in.nextInt());
								in.nextLine();
								break;
							case 4:
								System.out.print("Type in the new media type: ");
								medialist[i].setType(in.nextLine());
								break;
							default:
								System.out.print("Input out of bounds. Please try again. >");
						}
					} while (choice > 4 || choice < 1);
					
					System.out.println("Media successfully changed. >");
				}
			}
			
		}
	    // If no item with the entered ID is found, display a message
		if (found == false) {
			System.out.println("No items matched the entered ID.");
		}
	}		
	public void listCategory() {
		//Prompt the user to select the category of items to list
		System.out.print("Which kind of item would you like to list? \n"
				+"1. Book\n"
				+"2. Journal\n"
				+"3. Media\n"
				+"Please enter your choice > ");
		//Read user's choice
		int type = in.nextInt();
		//Do-while loop until a valid choice is entered (1,2 or 3)
		do {
			switch(type) {
				//Listing books
				case 1:
					for (int i=0;i<countBooks;i++) {
						System.out.println(booklist[i].toString());
					}
					break;
				//Listing journals
				case 2:
					for (int i=0;i<countJournals;i++) {
						System.out.println(journallist[i].toString());
					}
					break;
				//Listing medias
				case 3:
					for (int i=0;i<countMedias;i++) {
						System.out.println(medialist[i].toString());
					}
					break;
				default:
					System.out.print("\nInput out of bounds. Please try again. >");	
			}
		} while (type > 3 || type < 1);
	}
	public void showAll() {
		//Display all items from all categories
		//Print all iterations of book, journal and media lists
		for (int i=0;i<countBooks;i++) {
			System.out.println(booklist[i].toString());
		}
		for (int i=0;i<countJournals;i++) {
			System.out.println(journallist[i].toString());
		}					
		for (int i=0;i<countMedias;i++) {
			System.out.println(medialist[i].toString());
		}
	}
	public void addClient() {
		//Prompt the user to enter the new client's details
		System.out.print("Enter new client's name (ex: firstname_lastname):");
		String cname=in.next();
		System.out.print("Enter new client's phone number:");
		String cphone=in.next();
		System.out.print("Enter new client's email:");
		String cemail=in.next();
		//Create a new array to hold the new client
		Client [] copy=new Client[countClient+1];
		//Copy existing clients to the new array
		for(int i=0;i<countClient;i++) {
			copy[i]=clientlist[i];
		}
		//Add the new client to the end of the array
		copy[countClient]=new Client(cname, cphone,cemail);
		clientlist= (Client []) copy;
		//Increment the count of clients
		++countClient;
		System.out.println("Client successfully added.");
	}
	public void deleteClient() {
		//Prompt the user to enter the ID of the client to delete
		System.out.print("Which ID of client you would you like to delete: ");
		String id=in.next();
	    for (int i = 0; i < clientlist.length; i++) {
			//Check if the client with the entered ID exists in the system
	    	if (clientlist[i].getID().equals(id)) {
	    	found=true;
	    	//Decrement the client count
	    	--countClient;
	    	//Remove the client from the array
	    	clientlist[i]=null;
	    	//Create a new array to hold the updated list of clients
	    	Client [] copy=new Client[countClient];
	    	//Copy clients before the deleted item
	    	for (int j=0;j<i;j++) {
	    		copy[j]=clientlist[j];
	        }
	    	//Copy clients after the deleted item
	    	for (int k=i;k<countClient;k++) {
	    		copy[k]=clientlist[k+1];
	    	}
	    	//Update the reference to the client list
	    	clientlist=copy;
	    	System.out.println("Client successfully deleted.");
			}	
	    }
	    // If no client with the entered ID is found, display a message
	    if(found==false)
	    System.out.println("The client ID entered is not in the system.");
	}
	public void editClient() {
		//Prompt the user to enter the ID of the client to edit
		System.out.print("Enter ID of client you wish to edit: ");
		String id = in.next();
		//Iterate through the client list to find the client with the matching ID
		for (int i = 0; i<clientlist.length; i++) {
			if (clientlist[i].getID().equals(id)) {
				found = true;
				//Prompt the user to select which information to change
				System.out.print("Which information would you like to change?\n"
						+"1. Name\n"
						+"2. Phone Number\n"
						+"3. Email\n"
						+">");
				//Read user's choice
				int choice = in.nextInt();
				in.nextLine();
				
				do {
					switch (choice) {
						//Editing the name
						case 1:
							System.out.print("Type in the new name: ");
							clientlist[i].setName(in.nextLine());
							break;
						//Editing the phone number
						case 2:
							System.out.print("Type in the new phone number: ");
							clientlist[i].setPhone(in.next());
							break;
						//Editing the email
						case 3:
							System.out.print("Type in the new email: ");
							clientlist[i].setEmail(in.nextLine());
							break;
						default:
							System.out.print("Input is out of bounds. Please try again. >");
					}
				} while (choice > 3 || choice < 1); //Loop until a valid choice is entered
				System.out.println("Client successfully changed.");
			}
		}
	}
	public void leaseItem() {
		//Prompt the user to enter the leaser's ID
		System.out.print("Enter leaser's ID: ");
		String id=in.next();
		Client client=null;
		//Find the client with the entered ID
		for (int i =0;i<clientlist.length;i++) {
			if(clientlist[i].getID().equals(id)) {
				client=clientlist[i];}
		}
		//Check if the client exists and if they have reached the limit of leased items
		if(client !=null && client.countLeasedItems>9) {
			System.out.println("Client has reached limit of amount of books allowed to be leased at once.");
			return;
		}
		//If the client doesn't exist, display message and return
		if(client==null) {
			System.out.println("Entered client ID could not be found.");
			return;
		}
		//Prompt the user to enter the ID of the item being leased
		System.out.print("Enter ID of item being leased: ");
		String itemID=in.next();
		Item item=null;
	    // Find the item with the entered ID based on its category (Book, Journal, or Media)
		if(itemID.startsWith("B")) {
			for(int j=0;j<booklist.length;j++) {
				if(booklist[j].getID().equals(itemID)) {
					item=booklist[j];
				}			
			}
		}
		if (itemID.startsWith("J")) {
			for(int j=0;j<journallist.length;j++) {
				if(journallist[j].getID().equals(itemID)) {
					item=journallist[j];
				}			
			}	
		}
		if (itemID.startsWith("M")) {
			for(int j=0;j<medialist.length;j++) {
				if(medialist[j].getID().equals(itemID)) {
					item=medialist[j];
				}			
			}
		}
	    // If the item does not exist, display a message and return
		if (item==null) {
			System.out.println("Entered item ID could not be found.");
			return;
		}
	    // Lease the item to the client and update the leased item count
		client.leaseItem(item);
		System.out.println("Client successfully leased item.");
	}
	public void returnItem() {
		//Prompt the user to enter the leaser's ID
		System.out.print("Enter leaser's ID: ");
		String id=in.next();
		Client client=null;
	    // Find the client with the entered ID
		for (int i=0;i<clientlist.length;i++) {
			if(clientlist[i].getID().equals(id))
				client=clientlist[i];
		}
	    // If the client does not exist, display a message and return
		if(client==null) {
			System.out.println("Entered client ID could not be found.");
			return;
		}
	    // Prompt the user to enter the ID of the item being returned
		System.out.print("Enter ID of item being returned");
		String itemID=in.next();
		Item item=null;
	    // Find the leased item with the entered ID based on its category
		if(itemID.startsWith("B")) {
			for(int j=0;j<booklist.length;j++) {
				if(booklist[j].getID().equals(itemID)) {
					item=booklist[j];
				}			
			}
		}
		if (itemID.startsWith("J")) {
			for(int j=0;j<journallist.length;j++) {
				if(journallist[j].getID().equals(itemID)) {
					item=journallist[j];
				}			
			}	
		}
		if (itemID.startsWith("M")) {
			for(int j=0;j<medialist.length;j++) {
				if(medialist[j].getID().equals(itemID)) {
					item=medialist[j];
				}			
			}
		}
	    // If the item is not leased by the client, display a message and return
		if (item==null) {
			System.out.println("Client never leased this item.");
			return;
		}
	    // Return the item and update the leased item count
		client.returnItem(item);
		System.out.println("Client successfully returned item.");

	}
	public void showClientItems() {
	    // Prompt the user to enter the client's ID
		System.out.print("Type in the client (ID): ");
		String id = in.next();
	    // Find the client with the entered ID
		for (int i = 0; i<clientlist.length; i++) {
			if (clientlist[i].getID().equals(id)) {
				found = true;
	            // Get the list of leased items for the client
				Item [] leasedItems=clientlist[i].getLeased();
	            // Display the details of each leased item
				for (int j=0;j<clientlist[i].countLeasedItems;j++) {
				System.out.println(leasedItems[j].toString());
				}
			}
		}
	    // If no client with the entered ID is found, display a message
		if (found == false) {
			System.out.println("Entered client ID does not exist.");
		}	
	}
	public void showAllLeased() {
		//Iterate through all clients
		for (int i = 0; i<clientlist.length; i++) {
			//Get the list of leased items for each client
			Item [] leasedItems=clientlist[i].getLeased();
			//Display the details of each leased item
			for (int j=0;j<clientlist[i].countLeasedItems;j++) {
				System.out.println(leasedItems[j].toString());
			}
		}
	}
	public void showAllLeasedItems() {
		for (int i=0; i<countClient;i++) {
			Item [] leasedItems=clientlist[i].getLeased();
			for (int j=0;j<clientlist[i].countLeasedItems;j++) {
			System.out.println(leasedItems[j].toString());
			}
		}
	}
	public Book getBiggestBook() {
		//Initialize the biggest book with the first book in the book list
		Book biggestBook = booklist[0];
		//Iterate through all books to find the one with the most pages
		for (int i=0;i<countBooks;i++) {
			if(booklist[i].getNumOfPages()>biggestBook.getNumOfPages()) {
				biggestBook=booklist[i];
			}
		}
		return biggestBook;
	}
	public Book[] copyBookArray(Book[] booklist) {
		//Create a new array to store copies of books
		Book[] copyBookArray = new Book[booklist.length];
		//Iterate through the original book list and create copies of each book
		for (int i = 0; i < booklist.length; i++) {
			copyBookArray[i] = new Book(booklist[i]);
		}
		return copyBookArray;
	}
	

	
	public static void main(String[] args) {
		//Display welcome message
		System.out.println("Welcome to the FunReadings Library portal.");
		//Create a new instance of the Driver class
		Driver driver=new Driver();
		int choice;
		String input;
		System.out.println("Would you like to run a predefined scenario? (yes/no)");
        String scenario = driver.in.nextLine().toLowerCase();
        if (scenario.equals("yes")) {
            // Run predefined scenario
    	    Book book1 = new Book("Book 1", "Author 1", 2020, 300);
    	    Book book2 = new Book("Book 2", "Author 2", 2018, 250);
    	    Book book3 = new Book("Book 3", "Author 3", 2015, 400);

    	    Journal journal1 = new Journal("Journal 1", "Author 4", 2019, 5);
    	    Journal journal2 = new Journal("Journal 2", "Author 5", 2017, 3);
    	    Journal journal3 = new Journal("Journal 3", "Author 6", 2016, 7);

    	    Media media1 = new Media("Media 1", "Author 7", 2021, "DVD");
    	    Media media2 = new Media("Media 2", "Author 8", 2020, "Blu-ray");
    	    Media media3 = new Media("Media 3", "Author 9", 2019, "CD");    
    	    // Display information of created items
    	    System.out.println("Information of created items:");
    	    System.out.println(book1.toString());
    	    System.out.println(book2.toString());
    	    System.out.println(book3.toString());
    	    System.out.println(journal1.toString());
    	    System.out.println(journal2.toString());
    	    System.out.println(journal3.toString());
    	    System.out.println(media1.toString());
    	    System.out.println(media2.toString());
    	    System.out.println(media3.toString());
    	    System.out.println("\nTesting equality of objects:");

    	    // Test equality of two objects from different classes
    	    System.out.println("Equality of book1 and journal1: " + book1.equals(journal1));

    	    // Test equality of two objects from the same class with different values
    	    System.out.println("Equality of book1 and book2: " + book1.equals(book2));

    	    // Test equality of two objects of the same class with similar values
    	    Book book4 = new Book("Book 1", "Author 1", 2020, 300);
    	    System.out.println("Equality of book1 and book4: " + book1.equals(book4));
    	    // Create arrays for each type of item and all items
    	    driver.booklist = new Book[]{book1, book2, book3};
    	    driver.journallist = new Journal[]{journal1, journal2, journal3};
    	    driver.medialist = new Media[]{media1, media2, media3};

    	    // Create an array for all items
    	    driver.itemlist = new Item[]{book1, book2, book3, journal1, journal2, journal3, media1, media2, media3};
    	}
        //Run normal menu
        else if (scenario.equals("no")) {
		//Start a do-while loop to display the menu and handle user choices
			do {
				//Display the menu
				driver.displayMenu();
				//Get user choice
				choice=driver.in.nextInt();
				//Perform actions based on user choice
				switch(choice) {
					case 1:
						driver.addItem();
						break;
					case 2:
						driver.deleteItem();
						break;
					case 3:
						driver.editItem();
						break;
					case 4:
						driver.listCategory();
						break;
					case 5:
						driver.showAll();
						break;
					case 6:
						driver.addClient();
						break;
					case 7:
						driver.editClient();
						break;
					case 8:
						driver.deleteClient();
						break;
					case 9:
						driver.leaseItem();
						break;
					case 10:
						driver.returnItem();
						break;
					case 11:
						driver.showClientItems();
						break;
					case 12:
						driver.showAllLeasedItems();
						break;
					case 13:
						System.out.println(driver.getBiggestBook());
						break;
					case 14:
						Book [] copy= driver.copyBookArray(driver.booklist);
						for (int i=0;i<copy.length;i++)
							System.out.println(copy[i].toString());
						break;
				}
				//Ask user if they want to continue
				System.out.print("Would you like to continue? ");
				input=driver.in.next();
				input=input.toLowerCase();
			}while (choice>15 || choice<1 || input.equals("yes"));
       }
        //Option if user doesn't enter yes or no
       else {
            System.out.println("Invalid choice. Exiting program.");
        }
		//Display farewell message
		System.out.println("Thank you for using FunReadings Library portal. Goodbye!");
	}

}
