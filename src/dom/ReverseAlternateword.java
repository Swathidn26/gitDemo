package dom;

public class ReverseAlternateword {

	public static void main(String[] args) {
		String s1 = "Java is a programming language";
		char[] ch = s1.toCharArray();
		String s2 ="";
		int count = 0;
		for(int i=0;i<ch.length;i++) {
			String temp="";
			while(i<ch.length && ch[1]!=' ') {
				if(count%2!=0) {
					temp=ch[i]+temp;
				}
				else {
					temp=temp+ch[i];
				}
				i++;
			}
				count++;
				s2 = s2+temp;
			}
		System.out.println(s2);
		}

	}


