package dom;

public class Example {
	public static void main(String args[]) {
	String str = "my name is tester";
	String str2 = "program";
	boolean result = str.contains(str2);
	if(result) {
		System.out.println(str+ "  contains " +str2);
	}
	else {
		System.out.println(str+ " does not conatin " +str2);
	}
	
}
}

