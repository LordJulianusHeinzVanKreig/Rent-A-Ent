package application.database.entities;

public class Customer extends Person {
	private int Rating;

	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	
	public Customer(int id, String firstName, String lastName, String houseNumber, int zipCode, String street,
			String phoneNumber, int rating) {
		super(id, firstName, lastName, houseNumber, zipCode, street, phoneNumber);
		Rating = rating;
	}
}
