package application.entities;

public abstract class DatabaseEntity {
	private int Id;
	
	public int getId() {
		return this.Id;
	}
	
	public DatabaseEntity(int id) {
		this.Id = id;
	}
}
