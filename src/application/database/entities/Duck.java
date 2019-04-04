package application.database.entities;

public class Duck extends DatabaseEntity {
	private int Age;
	private String Name;
	private String Description;
	private int Temperament;
	private boolean Gender;
	private DuckType Type;
	
	public DuckType getType() {
		return Type;
	}
	public void setType(DuckType type) {
		this.Type = type;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getTemperament() {
		return Temperament;
	}
	public void setTemperament(int temperament) {
		Temperament = temperament;
	}
	public boolean isGender() {
		return Gender;
	}
	public void setGender(boolean gender) {
		Gender = gender;
	}
	
	public Duck(int id, int age, String name, String description, int temperament, boolean gender, DuckType type) {
		super(id);
		Age = age;
		Name = name;
		Description = description;
		Temperament = temperament;
		Gender = gender;
		Type = type;
	}
}
