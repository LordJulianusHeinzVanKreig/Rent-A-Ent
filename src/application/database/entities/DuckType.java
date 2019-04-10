package application.database.entities;

import java.util.Date;

public class DuckType extends DatabaseEntity {
	
	private Date BreedTime;
	private String Region;
	private int maxAge;
//	private String Name;
//	
//	public String getName() {
//		return Name;
//	}
//	public void setName(String name) {
//		Name = name;
//	}
	public Date getBreedTime() {
		return BreedTime;
	}
	public void setBreedTime(Date breedTime) {
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
	
	
	public DuckType(int id, Date breedTime, String region, int maxAge) {
		super(id);
		BreedTime = breedTime;
		Region = region;
		this.maxAge = maxAge;
//		Name = name;
	}
}
