package databases.assignment.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Random;

/**
 * Assumes that a student can have at most one grade in a particular course
 * 
 * Hardcoded String constants for convenience
 * @author Mark Chmilar
 *
 */

public class QuestionOne {

	private static Database db;
	private static final int ASCII_A = 65;
	private static final int NUM_STUDENTS = 25;
	private static final int YEAR = 2017;
	private static final String DELIMETER = ";";
	private static Random random = new Random();
	
	private static void main(String[] args) throws FileNotFoundException {
		db = new Database();
		
		// Build students
		buildStudents();
		outputStudentRelation(db.getStudents());
		
		// Build courses
		buildCourses();
		
		// Build Grades
		buildGrades();
	}
	
	private static void outputStudentRelation(Map<Integer, Student> relation) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("students.csv"));
		StringBuilder sb = new StringBuilder();
		sb.append("SID");
		sb.append(DELIMETER);
		sb.append("SName");
		sb.append(DELIMETER);
		sb.append("Major");
		sb.append(DELIMETER);
		sb.append("email");
		sb.append(DELIMETER + "\n");
		
		for (Student student : relation.values()) {
			sb.append(student.getSid());
			sb.append(DELIMETER);
			sb.append(student.getName());
			sb.append(DELIMETER);
			sb.append(student.getMajor());
			sb.append(DELIMETER);
			sb.append(student.getEmail());
			sb.append(DELIMETER + "\n");
		}
	}
	
	private static void buildGrades() {
		// Build Grades by putting each student into two random courses
		// Student cannot be in the same course twice
		System.out.println("Building Grades relation...");
		for (int i = 0; i < 2; i++) {
			for (Integer id : db.getStudents().keySet()) {
				assignRandomGrade(id);
			}
		}
	}
	
	private static void buildCourses() {
		System.out.println("Building Courses relation...");
		db.insert(new Course(1, Course.DATABASES, 4));
		db.insert(new Course(2, Course.AI, 4));
		db.insert(new Course(3, Course.ALGORITHMS, 3));
		db.insert(new Course(4, Course.OOP, 3));
		System.out.println("Finished building Courses relation.");
	}
	
	private static void buildStudents() {
		System.out.println("Building Students relation...");
		for (int i = 0; i < NUM_STUDENTS; i++) {
			char c = (char) (i + ASCII_A);
			char nameChar[] = {c, c, c, c};
			String name = String.valueOf(nameChar);
			int id = i + 1;
			String major = randomMajor();
			String email = name + "@gmail.com";
			
			db.insert(new Student(id, name, major, email));
		}
		System.out.println("Finished building Students relation.\n\n");
	}
	
	private static void assignRandomGrade(int sid) {
		Map<String, Grade> currentGrades = db.getGrades();
		boolean gradeAssigned = false;
		while (!gradeAssigned) {
			int cid = randomCid();
			String semester = randomSemester();
			String gLetter = randomGradeLetter();
			String pKey = String.valueOf(sid) + String.valueOf(cid) + semester;
			// only insert if we don't have this key yet
			if (!currentGrades.containsKey(pKey)) {
				db.insert(new Grade(sid, cid, YEAR, semester, gLetter));
				gradeAssigned = true;
			} 
		}
	}
	
	private static String randomSemester() {
		int randomNumber = random.nextInt(3);
		switch (randomNumber) {
		case 0: return Grade.FALL;
		case 1: return Grade.SUMMER;
		case 2: return Grade.WINTER;
		}
		return "Mars"; // helps debug, if we see this there's a problem
	}
	
	private static int randomCid() {
		return random.nextInt(4) + 1;
	}
	
	private static String randomGradeLetter() {
		int randomNumber = random.nextInt(13);
		switch (randomNumber) {
		case 0: return "A+";
		case 1: return "A";
		case 2: return "A-";
		case 3: return "B+";
		case 4: return "B";
		case 5: return "B-";
		case 6: return "C+";
		case 7: return "C";
		case 8: return "C-";
		case 9: return "D+";
		case 10: return "D";
		case 11: return "D-";
		case 12: return "F";
		}
		return "G"; // helps debug, if we see this there's a problem
	}
	
	private static String randomMajor() {
		int randomNumber = random.nextInt(3);
		switch (randomNumber) {
		case 0: return Student.CE;
		case 1: return Student.CS;
		case 2: return Student.SE;
		}
		return "History"; // help debug, if we see this there's a problem
	}
}
