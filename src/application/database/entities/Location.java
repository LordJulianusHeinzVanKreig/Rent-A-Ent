package application.database.entities;

public class Location extends DatabaseEntity {
	private String Street;
	private int ZipCode;
	private String HouseNumber;
	private Worker Leader;
	
	public Worker getLeader() {
		return Leader;
	}
	public void setLeader(Worker leader) {
		Leader = leader;
	}
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
	
	public Location(int id, String street, int zipCode, String houseNumber, Worker leader) {
		super(id);
		Street = street;
		ZipCode = zipCode;
		HouseNumber = houseNumber;
		Leader = leader;
	}
}
