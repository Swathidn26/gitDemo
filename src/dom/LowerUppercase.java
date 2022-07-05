package dom;

public class LowerUppercase {

	public static void main(String[] args) {
		String str = "GreAt PwoEr";
		StringBuffer str2 = new StringBuffer(str);
		
		for(int i =0;i<str.length();i++) {
			if(Character.isLowerCase(str.charAt(i))) {
				str2.setCharAt(i, Character.toUpperCase(str.charAt(i)));
			}
			else if(Character.isUpperCase(str.charAt(i))) {
				str2.setCharAt(i, Character.toLowerCase(str.charAt(i)));
			}
		}
		System.out.println(str2);

	}

}
