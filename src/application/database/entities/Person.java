package application.database.entities;

public abstract class Person extends DatabaseEntity {
	
	private String FirstName;
	private String LastName;
	private String HouseNumber;
	private int ZipCode;
	private String Street;
	private String PhoneNumber;
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getHouseNumber() {
		return HouseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		HouseNumber = houseNumber;
	}
	public int getZipCode() {
		return ZipCode;
	}
	public void setZipCode(int zipCode) {
		ZipCode = zipCode;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	public Person(int id, String firstName, String lastName, String houseNumber, int zipCode, String street,
			String phoneNumber) {
		super(id);
		FirstName = firstName;
		LastName = lastName;
		HouseNumber = houseNumber;
		ZipCode = zipCode;
		Street = street;
		PhoneNumber = phoneNumber;
	}
}
