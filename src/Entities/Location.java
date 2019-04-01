package Entities;

public class Location extends DatabaseEntity {
	private String Street;
	private int ZipCode;
	private String HouseNumber;
	
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public int getZipCode() {
		return ZipCode;
	}
	public void setZipCode(int zipCode) {
		ZipCode = zipCode;
	}
	public String getHouseNumber() {
		return HouseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		HouseNumber = houseNumber;
	}
	
	public Location(int id, String street, int zipCode, String houseNumber) {
		super(id);
		Street = street;
		ZipCode = zipCode;
		HouseNumber = houseNumber;
	}
}
