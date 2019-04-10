package application.database.entities;

public class DuckType extends DatabaseEntity {
	
	private int BreedTime;
	private String Region;
	private int maxAge;
	private String Name;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getBreedTime() {
		return BreedTime;
	}
	public void setBreedTime(int breedTime) {
		BreedTime = breedTime;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	
	
	public DuckType(int id, String name, int breedTime, String region, int maxAge) {
		super(id);
		BreedTime = breedTime;
		Region = region;
		this.maxAge = maxAge;
		Name = name;
	}
}
