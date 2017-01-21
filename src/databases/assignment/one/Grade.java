package databases.assignment.one;

public class Grade {
	private int sid;
	private int cid;
	private int year;
	private String semester;
	private String grade;
	
	public static final String SUMMER = "Summer";
	public static final String FALL = "Fall";
	public static final String WINTER = "Winter";
	
	public Grade(int sid, int cid, int year, String semester, String grade) {
		super();
		this.sid = sid;
		this.cid = cid;
		this.year = year;
		this.semester = semester;
		this.grade = grade;
	}
	
	// The key is the SID concatenated with CID and semester
	// EG: if SID=23 and CID=127 and semester = Fall then key=23127Fall
	public String getPrimaryKey() {
		return String.valueOf(sid) + String.valueOf(cid) + semester;
	}
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
