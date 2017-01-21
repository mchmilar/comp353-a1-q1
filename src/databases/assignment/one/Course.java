package databases.assignment.one;

public class Course {
	private int id;
	private String name;
	private int credits;
	
	public static final String DATABASES = "Databases";
	public static final String OOP = "Object Oriented Programming";
	public static final String ALGORITHMS = "Data Structures & Algorithms";
	public static final String AI = "Artificial Intelligence";
	
	public Course(int id, String name, int credits) {
		super();
		this.id = id;
		this.name = name;
		this.credits = credits;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	
}
