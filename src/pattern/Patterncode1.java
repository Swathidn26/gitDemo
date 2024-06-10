package pattern;

public class Patterncode1 {
	
	public static void main(String[] args) {
		
//		1
//		2 2
//		3 3 3
//		4 4 4 4
//		5 5 5 5 5
		
		
		int i, j, n=5, num =1;
		
		for(i=0;i<n;i++)
		{
			for(j=0;j<=i;j++) {
				System.out.print(num+ " ");
				
				
			}
			num=num+1;
			System.out.println();
		}
		
		
			

	}

}



