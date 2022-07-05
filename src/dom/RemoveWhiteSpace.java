package dom;

public class RemoveWhiteSpace {

	public static void main(String[] args) {
		
		String str = "Remove white  space";
		str = str.replaceAll(" ", "");
		System.out.println(str);

	}

}
