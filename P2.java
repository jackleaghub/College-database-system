//Jack Lea
import java.util.Scanner;

public class P2 {
	public static void main(String[] args) {
		
		//declarations
		Person[] personArray = new Person[100];
		Scanner myScanner = new Scanner(System.in);
		boolean continue_flag = true;
		printOptions optionsPrinter = new printOptions();
		int openPerson = 0;
		char chosenOption;
		String inputName, inputID, inputDepartment, inputRank, inputStatus;
		double inputGPA;
		int inputCreditHours;
		
		//continue flag is turned to false when user opts to exit program
		while (continue_flag) {
			
			//prints options for user
			System.out.println(optionsPrinter);
			System.out.print("Choose one of the options: ");
			chosenOption = myScanner.next().charAt(0);
			
			//chosenOption is char so it does not crash if a letter is input
			switch(chosenOption) {
			
			//ENTER THE INFORMATION OF A FACULTY
			case '1':
				System.out.print("\n\nEnter the faculty info: \n");
				
				System.out.print("      Name of the faculty: ");
				inputName = myScanner.nextLine();
				inputName = myScanner.nextLine();
				System.out.print("\n");
				
				System.out.print("      ID: ");
				inputID = myScanner.nextLine();
				System.out.print("\n");
				
				System.out.print("      Rank: ");
				inputRank = myScanner.nextLine();
				//makes inputRank lower case then loops until inputRank is a valid rank
				inputRank = inputRank.toLowerCase();
				while(!inputRank.equals("professor") && !inputRank.equals("adjunct")) {
					System.out.print("      \"" + inputRank + "\" is invalid\n");
					System.out.print("      Rank: ");
					inputRank = myScanner.nextLine();
					inputRank = inputRank.toLowerCase();
				}
				
				System.out.print("\n");
				
				System.out.print("      Department: ");
				inputDepartment = myScanner.nextLine();
				//lower case then loops until valid department (same process as inputDepartment)
				inputDepartment = inputDepartment.toLowerCase();
				while(!inputDepartment.equals("engineering") && !inputDepartment.equals("sciences") && !inputDepartment.equals("mathematics")) {
					System.out.print("      \"" + inputDepartment + "\" is invalid\n");
					System.out.print("      Department: ");
					inputDepartment = myScanner.nextLine();
					inputDepartment = inputDepartment.toLowerCase();
				}
				System.out.print("\n");
				
				//creates new faculty member with correct information at the openPerson slot, then increments openPerson with to open the next slot
				personArray[openPerson] = new Faculty(inputName, inputID, inputDepartment, inputRank);
				openPerson++;
				
				System.out.print("Faculty added!\n\n\n\n");
				break;
				
			//ENTER THE INFORMATION OF A STUDENT
			case '2':
				System.out.print("\n\nEnter the student info: \n");
				
				System.out.print("      Name of the student: ");
				inputName = myScanner.nextLine();
				inputName = myScanner.nextLine();
				System.out.print("\n");
				
				System.out.print("      ID: ");
				inputID = myScanner.nextLine();
				System.out.print("\n");
				
				System.out.print("      GPA: ");
				inputGPA = myScanner.nextDouble();
				System.out.print("\n");
				
				System.out.print("      Credit Hours: ");
				inputCreditHours = myScanner.nextInt();
				System.out.print("\n");
				
				//creates new student with correct information at the openPerson slot, then increments openPerson with to open the next slot
				personArray[openPerson] = new Student(inputName, inputID, inputGPA, inputCreditHours);
				openPerson++;
				
				System.out.print("Student added!\n\n\n\n");
				break;
				
			//PRINT TUITION INVOICE FOR A STUDENT
			case '3':
				System.out.print("\n\nEnter the student's id: ");
				inputID = myScanner.nextLine();
				inputID = myScanner.nextLine();
				System.out.print("\n");
				
				//no one has been added
				if (openPerson == 0) {
					System.out.print("No student matched!\n");
				}
				//checks person array to see if a student with inputID exists
				for(int i = 0; i < openPerson; i++) {
					//if ID matches, calls print() to print tuition invoice
					if (personArray[i].getID().equals(inputID)) {
						personArray[i].print();
						break;
					}
					//traversed entire array then prints that no student matches
					else if (i == openPerson-1) {
						System.out.print("No student matched!\n");
					}
				}
				break;
				
			//PRINT FACULTY INFORMATION
			case '4':
				System.out.print("\n\nEnter the Faculty's id: ");
				inputID = myScanner.nextLine();
				inputID = myScanner.nextLine();
				System.out.print("\n");
				
				//no one has been added
				if (openPerson == 0) {
					System.out.print("No faculty matched!\n");
				}
				//checks person array to see if a student with inputID exists
				for(int i = 0; i < openPerson; i++) {
					//if ID matches, calls print() to print tuition invoice
					if (personArray[i].getID().equals(inputID)) {
						personArray[i].print();
						break;
					}
					//traversed entire array then prints that no student matches
					else if (i == openPerson-1) {
						System.out.print("No faculty matched!\n");
					}
				}
				break;
				
			//ENTER THE INFORMATION OF A STAFF MEMBER
			case '5':
				System.out.print("\n\nName of the staff member: ");
				inputName = myScanner.nextLine();
				inputName = myScanner.nextLine();
				System.out.print("\n");
				
				System.out.print("Enter the id: ");
				inputID = myScanner.nextLine();
				System.out.print("\n");
				
				System.out.print("Department: ");
				inputDepartment = myScanner.nextLine();
				//lower case then loops until valid department
				inputDepartment = inputDepartment.toLowerCase();
				while(!inputDepartment.equals("engineering") && !inputDepartment.equals("sciences") && !inputDepartment.equals("mathematics")) {
					System.out.print("      \"" + inputDepartment + "\" is invalid\n");
					System.out.print("Department: ");
					inputDepartment = myScanner.nextLine();
					inputDepartment = inputDepartment.toLowerCase();
				}
				System.out.print("\n");
				
				System.out.print("Status, Enter P for Part Time, or Enter F for Full Time: ");
				inputStatus = myScanner.nextLine();
				inputStatus = inputStatus.toLowerCase();
				System.out.print("\n");
				
				//creates new staff member with correct information at the openPerson slot, then increments openPerson with to open the next slot
				personArray[openPerson] = new Staff(inputName, inputID, inputDepartment, inputStatus);
				openPerson++;
				
				System.out.print("Staff member added!\n\n\n\n");
				break;
				
			//PRINT THE INFORMATION OF A STAFF MEMBER
			case '6':
				System.out.print("\n\nEnter the Staff's id: ");
				inputID = myScanner.nextLine();
				inputID = myScanner.nextLine();
				System.out.print("\n");
				
				//no one has been added
				if (openPerson == 0) {
					System.out.print("No staff matched!\n");
				}
				//checks person array to see if a student with inputID exists
				for(int i = 0; i < openPerson; i++) {
					//if ID matches, calls print() to print tuition invoice
					if (personArray[i].getID().equals(inputID)) {
						personArray[i].print();
						break;
					}
					//traversed entire array then prints that no student matches
					else if (i == openPerson-1) {
						System.out.print("No staff matched!\n");
					}
				}
				break;
				
			//EXIT PROGRAM
			case '7':
				//stops loop asking for entries
				myScanner.close();
				continue_flag = false;
				break;
			default:
				System.out.println("Invalid entry- please try again\n");
				break;
			}
			
		}
		
	}// end of main
}// end of P1

class printOptions {
	public String toString() {
		return "Choose one of the options:\n\n"
				+ "1- Enter the information of a faculty\n"
				+ "2- Enter the information of a student\n"
				+ "3- Print tuition invoice for a student\n"
				+ "4- Print faculty information\n"
				+ "5- Enter the information of a staff member\n"
				+ "6- Print the information of a staff member\n"
				+ "7- Exit Program\n";
	}
}

abstract class Person {
	private String FullName;
	private String ID;
	
	//-------------------------
	
	public String toString() {
		return FullName + "			" + ID;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String FullName) {
		this.FullName = FullName;
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public Person() {
		FullName = "";
		ID = "";
	}
	public Person(String FullName, String ID) {
		setFullName(FullName);
		setID(ID);
	}
	public abstract void print();
}

class Student extends Person{
	private double GPA;
	private int CreditHours;
	
	//-------------------------
	
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double GPA) {
		this.GPA = GPA;
	}
	public int getCreditHours() {
		return CreditHours;
	}
	public void setCreditHours(int CreditHours) {
		this.CreditHours = CreditHours;
	}
	public Student(String FullName, String ID, double GPA, int CreditHours) {
		super(FullName, ID);
		setGPA(GPA);
		setCreditHours(CreditHours);
	}
	@Override
	public void print() {
		System.out.println("\nHere is the tuition invoice for " + getFullName() + " :\n\n");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.print(getFullName() + "              " + getID() + "\n");
		System.out.print("Credit Hours: " + getCreditHours() + "($236.45/credit hour)\n");
		System.out.print("Fees: $52\n\n\n");
		//if the gpa is greater or equal to 3.85 the discount is applied and doubles are printed to the hundredth place
		if (getGPA() >= 3.85) {
			double newPayment = (getCreditHours() * 236.45) * .75;
			double discount = (getCreditHours() * 236.45) * .25;
			System.out.printf("Total payment (after discount): $%.2f              ($%.2f discount applied)\n", newPayment, discount);
			System.out.print("----------------------------------------------------------------------------------\n\n\n\n");
		}
		else {
			double payment = (getCreditHours() * 236.45);
			System.out.printf("Total payment (after discount): $%.2f                      ($0 discount applied)\n", payment);
			System.out.print("----------------------------------------------------------------------------------\n\n\n\n");
		}
	}
}

abstract class Employee extends Person {
	private String Department;

	//-------------------------
	
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String Department) {
		this.Department = Department;
	}
	public Employee() {
		super();
		Department = "";
	}
	public Employee(String FullName, String ID, String Department) {
		super(FullName, ID);
		setDepartment(Department);
	}
}

class Faculty extends Employee{
	private String Rank;

	//-------------------------
	
	public String getRank() {
		return Rank;
	}
	public void setRank(String Rank) {
		this.Rank = Rank;
	}
	public Faculty(String FullName, String ID, String Department, String Rank) {
		super(FullName, ID, Department);
		setRank(Rank);
	}
	@Override
	public void print() {
		System.out.println("\n----------------------------------------------------------------------------------");
		System.out.println(getFullName() + "          " + getID());
		//proper formatting for each possible entry
		if (getDepartment().equals("engineering")) {
			System.out.print("Engineering Department, ");
		}
		else if (getDepartment().equals("sciences")) {
			System.out.print("Science Department, ");
		}
		else if (getDepartment().equals("mathematics")) {
			System.out.print("Mathematics Department, ");
		}
		if (getRank().equals("professor")) {
			System.out.print("Professor\n");
		}
		else if (getRank().equals("adjunct")) {
			System.out.print("Adjunct\n");
		}
		System.out.println("----------------------------------------------------------------------------------\n\n\n\n");
	}
}

class Staff extends Employee{
	private String Status;

	//-------------------------
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Staff(String FullName, String ID, String Department, String Status) {
		super(FullName, ID, Department);
		setStatus(Status);
	}
	@Override
	public void print() {
		System.out.println("\n----------------------------------------------------------------------------------");
		System.out.println(getFullName() + "          " + getID());
		//proper formatting for each possible entry
		if (getDepartment().equals("engineering")) {
			System.out.print("Engineering Department, ");
		}
		else if (getDepartment().equals("sciences")) {
			System.out.print("Science Department, ");
		}
		else if (getDepartment().equals("mathematics")) {
			System.out.print("Mathematics Department, ");
		}
		if (getStatus().equals("p")) {
			System.out.print("Part Time\n");
		}
		else if (getStatus().equals("f")) {
			System.out.print("Full Time\n");
		}
		System.out.println("----------------------------------------------------------------------------------\n\n\n\n");
	}
}