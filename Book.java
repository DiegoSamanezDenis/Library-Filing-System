package library;

//Book class extends the Item class
public class Book extends Item {
		//Additional attribute specific to book class
		private int numOfPages;
		//Static variable to keep track of IDs
		private static int idNumber=0;
		
		//Default constructor
		public Book() {}
		//Parameterized constructor
		public Book(String name, String author, int yearOfPublication, int numOfPages) {
			//Call to super constructor to initialize inherited attributes
			super(name,author,yearOfPublication);
			//Generate unique ID for the book
			this.ID=makeID();
			this.numOfPages=numOfPages;
		}
		//Copy constructor
		public Book(Book other) {
			this.ID=other.makeID();
			this.name=other.name;
			this.author=other.author;
			this.yearOfPublication=other.yearOfPublication;
			this.numOfPages=other.numOfPages;
		}
		//Getter and setter for number of pages
		public int getNumOfPages() {
			return numOfPages;
		}
		public void setNumOfPages(int numOfPages) {
			this.numOfPages = numOfPages;
		}
		//Override toString method to provide custom string of Book object
		@Override
		public String toString() {
			return "ID= "+ID+", "+super.toString()+", Number of Pages= "+numOfPages;
		}
		//Overloading equals method to compare two Book objects 
		public boolean equals(Book other) {
			return this.makeID()==(other.makeID())&&this.name.equals(other.name)&&this.author.equals(other.author)&&this.yearOfPublication==other.yearOfPublication&&this.numOfPages==other.numOfPages;
		}
		//Method to generate unique ID for Book
		public String makeID() {
			idNumber++;
			return "B"+idNumber;

		}

}


