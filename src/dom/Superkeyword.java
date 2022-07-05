package dom;

public class Superkeyword {

	String color = "black";
	
}

class Dog extends Superkeyword {
	
	String color = "white";
public void printColor() {	
	System.out.println(color);
	System.out.println(super.color);
	
}
}

class TestSuper{
	public static void main(String[]args) {
		Dog d = new Dog();
		d.printColor();
	}
}
