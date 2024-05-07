package library;

//Media class extends Item class
public class Media extends Item{
		//Additional attribute specific to media
		private String type;
		//Static variable to generate unique Media ID numbers
		private static int idnumber=0;
		
		//Default constructor
		public Media() {}
		//Parameterized constructor
		public Media(String name, String author, int yearOfPublication, String type) {
			//Call super constructor to initialize inherited attributes
			super(name,author,yearOfPublication);
			//Generate unique ID for the Media
			this.ID=makeID();
			this.type=type;
		}
		//Copy constructor
		public Media(Media other) {
			this.ID=other.makeID();
			this.name=other.name;
			this.author=other.author;
			this.yearOfPublication=other.yearOfPublication;
			this.type=other.type;
		}
		
		//Getter and setter methods for type
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type=type;
		}
		//Override toString method to provide custom string for Media object
		@Override
		public String toString() {
			return "ID= "+ID+", "+super.toString()+", Type= "+type;
		}
		//Overloading equals method to compare two Media objects
		public boolean equals(Media other) {
			return this.getID().equals(other.getID())&&this.name.equals(other.name)&&this.author.equals(other.author)&&this.yearOfPublication==other.yearOfPublication&&this.type.equals(other.type);
		}
		//Method to generate unique ID for each journal
		public String makeID() {
			idnumber++;	
			return "M"+idnumber;
		}
		
		
	}

