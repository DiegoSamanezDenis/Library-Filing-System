package Client;

import library.Item;

//Client class representing a client of the library
public class Client {
	//Attributes of the client
	private String ID;
	private String name;
	private String phone;
	private String email;
	//Static variable to keep track of IDs
	private static int idnumber=0;
	//Array to store leased items
	private Item [] leasedItems;
	//Counter for the number of leased items
	public int countLeasedItems=0;
	
	//Default constructor
	public Client() {}
	//Parameterized constructor
	public Client(String name, String phone, String email) {
		//Generate unique ID for the Client
		this.ID=makeID();
		this.name=name;
		this.phone=phone;
		this.email=email;
		//Initialize leasedItems array so that client can lease a maximum of 10 items
		this.leasedItems=new Item[10];
	}
	//Copy constructor
	public Client(Client other) {
		this.ID=makeID();
		this.name=other.name;
		this.phone=other.phone;
		this.email=other.email;
	}
	
	//Getter and setter methods for ID, name, phone and email
	
	public String getID() {
		return this.ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//Override toString method to provide a custom string for Client object
	public String toString() {
		return "ID= "+ID+", Name= "+name+", Phone Number= "+phone+", Email= "+email;
	}
	//Overloading equals method to compare two Client objects
	public boolean equals(Client other) {
		return this.ID.equals(other.ID)&&this.name.equals(other.name)&&this.phone.equals(other.phone)&&this.email.equals(other.email);
	}
	//Method to generate unique ID for each Client
	public String makeID() {
		idnumber++;
		return "C"+idnumber;
	}
	//Method to get the array of leased items
	public Item [] getLeased() {
		return leasedItems;
	}
	//Method to lease an item to the client
    public void leaseItem(Item item) {
        leasedItems[countLeasedItems++] = item;
    }
    //Method to return an item from the client
    public void returnItem(Item item) {
    	leasedItems[countLeasedItems--]=item;
    }
}
	