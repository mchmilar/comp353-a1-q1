package databases.assignment.one;

public class Student {
	private int id;
	private String name;
	private String major;
	private String email;
	
	public static final String CS = "Computer Science";
	public static final String SE = "Software Engineering";
	public static final String CE = "Computer Engineering";
	
	public Student(int sid, String sName, String major, String email) {
		this.id = sid;
		this.name = sName;
		this.major = major;
		this.email = email;
	}

	public int getSid() {
		return id;
	}

	public void setSid(int sid) {
		this.id = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String sName) {
		this.name = sName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
