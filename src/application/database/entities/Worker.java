package application.database.entities;

public class Worker extends Person {
	private int Age;
	private int WorkHours;
	
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getWorkHours() {
		return WorkHours;
	}
	public void setWorkHours(int workHours) {
		WorkHours = workHours;
	}
	
	public Worker(int id, String firstName, String lastName, String houseNumber, int zipCode, String street,
			String phoneNumber, int age, int workHours) {
		super(id, firstName, lastName, houseNumber, zipCode, street, phoneNumber);
		Age = age;
		WorkHours = workHours;
	}
}
