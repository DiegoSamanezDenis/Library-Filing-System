package library;

//Journal class extends the Item class
public class Journal extends Item{
		//Additional attribute specific to Journal
		private int volumeNumber;
		//Static variable to generate unique ID numbers
		private static int idnumber=0;
		
		//Default constructor
		public Journal() {}
		//Parameterized constructor
		public Journal(String name, String author, int yearOfPublication, int volumeNumber) {
			//Call super constructor to initialize inherited attributes
			super(name,author,yearOfPublication);
			this.volumeNumber=volumeNumber;
			//Generate random Journal ID
			this.ID=makeID();
		}
		//Copy constructor
		public Journal(Journal other) {
			this.ID=other.makeID();
			this.name=other.name;
			this.author=other.author;
			this.yearOfPublication=other.yearOfPublication;
			this.volumeNumber=other.volumeNumber;
		}
		
		//Getter and setter methods for volume number
		
		public int getVolumeNumber() {
			return volumeNumber;
		}
		public void setVolumeNumber(int volumeNumber) {
			this.volumeNumber=volumeNumber;
		}
		//Override toString method to provide custom string of Journal object
		@Override
		public String toString() {
			return "ID= "+ID+", "+super.toString()+", Volumer Number= "+volumeNumber;
		}
		//Overloading equals method to compare two Journal objects
		public boolean equals(Journal other) {
			return this.getID().equals(other.getID())&&this.name.equals(other.name)&&this.author.equals(other.author)&&this.yearOfPublication==other.yearOfPublication&&this.volumeNumber==other.volumeNumber;
		}
		//Method to generate unique ID for each journal
		public String makeID() {
			idnumber++;
			return "J"+idnumber;
		}
		
	}

