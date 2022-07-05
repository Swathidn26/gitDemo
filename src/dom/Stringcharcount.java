package dom;

public class Stringcharcount {

	public static void main(String[] args) {

		String str = "swathi dhananjay";
		char str2[]= str.toCharArray();
		
		
		for(int i=0;i<str2.length;i++) {
			int count = 1;
			for(int j=i+1;j<str2.length;j++) {
				if(str2[i]==str2[j] && str2[i]!=' ') {
					count++;
				}
			}
			System.out.println(str2[i]+ " "+count);
		}
	}

}
