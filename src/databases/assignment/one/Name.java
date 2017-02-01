package databases.assignment.one;

import java.util.Random;

public enum Name {
	Mark, Tarik, 
	Laura, Justin, 
	Matt, Jackie, 
	Erin, Rick, 
	Justine, Eric, 
	Luke, Nancy, 
	Bob, July, 
	Mel, Tash, 
	Jill, Carol, 
	Azure, Jen;
	
	private static Name[] names = Name.values();
	
	private static Random random = new Random();
	
	public static final Name random() {
		return names[random.nextInt(names.length)];
	}
	

}
