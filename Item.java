package library;

//Abstract class representing an item in the library
public abstract class Item {
		//attributes common to all items
		protected String ID;
		protected String name;
		protected String author;
		protected int yearOfPublication;
		
		//Default constructor
		public Item() {}
		//Parameterized constructor
		public Item(String name, String author, int yearOfPublication) {
			this.name=name;
			this.author=author;
			this.yearOfPublication=yearOfPublication;
		}
		//Copy constructor
		public Item(Item other) {
			this.ID=other.makeID();
			this.name=other.name;
			this.author=other.author;
			this.yearOfPublication=other.yearOfPublication;
		}
		
		//Getter and Setter methods for ID, name, author and year of publication
		
		public void setID(String ID) {
			this.ID=ID;
		}
		public String getID() {
			return this.ID;
		}
		public void setName(String name) {
			this.name=name;
		}
		public String getName() {
			return this.name;
		}
		public void setAuthor(String author) {
			this.author=author;
		}
		public String getAuthor() {
			return this.author;
		}
		public void setYearOfPublication(int yearOfPublication) {
			this.yearOfPublication=yearOfPublication;
		}
		public int getYearOfPublication() {
			return yearOfPublication;
		}

		//toString method to provide custom string of Item object
		public String toString() {
			return "Name= "+name+", Author= "+author+", Year of Publication= "+yearOfPublication;
		}
		//Equals method to compare two Item objects
		public boolean equals(Item other) {
			return (this.ID.equals(other.ID)&&this.name.equals(other.name)&&this.author.equals(other.author)&&this.yearOfPublication==other.yearOfPublication);
		}
		//Abstract method to generate unique ID for each Item
		public abstract String makeID();

		
}

