package databases.assignment.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {
	private Map<Integer, Student> students;
	private Map<Integer, Course> courses;
	private Map<String, Grade> grades;
	
	public Database() {
		students = new HashMap<Integer, Student>();
		courses = new HashMap<Integer, Course>();
		grades = new HashMap<String, Grade>();
	}
	
	public void insert(Student student) {
		students.put(student.getSid(), student);
	}
	
	public void insert(Course course) {
		courses.put(course.getId(), course);
	}
	
	public void insert(Grade grade) {
		// The key is the SID concatenated with CID
		// EG: if SID=23 and CID=127 then key=23127
		String key = grade.getPrimaryKey();
		grades.put(key, grade);
	}
	
	public String fetchDatabaseStudents() {
		int dbCid = 0;
		String result = "Name\t\t|\t\tID\t\t|\t\tGrade\n";
		result += "----------------------------------------------------------";
		// Find Databases CID
		for (Integer cid : courses.keySet()) {
			String cName = courses.get(cid).getName();
			if (cName.equals(Course.DATABASES)) {
				dbCid = cid;
			}
		}
		
		// Iterate through the grades to find the students who took Databases
		for (String pKey : grades.keySet()) {
			Grade grade = grades.get(pKey);
			int cid = grade.getCid();
			
			if (dbCid == cid) {
				int sid = grade.getSid();
				String sName = students.get(sid).getName();
				String gradeLetter = grade.getGrade();
				
				result += sName + "\t\t|\t\t" + sid + "\t\t|\t\t" + gradeLetter;
				result += "----------------------------------------------------------";
			}
		}
		
		return result;
	}

	public Map<Integer, Student> getStudents() {
		return new HashMap<Integer, Student>(students);
	}

	public Map<Integer, Course> getCourses() {
		return new HashMap<Integer, Course>(courses);
	}

	public Map<String, Grade> getGrades() {
		return new HashMap<String, Grade>(grades);
	}
	
	
}
