package pattern;

public class PatternCode2 {
	
	public static void main(String[] args) {
//		1
//		2 3
//		4 5 6
//		7 8 9 10
		
		
		
		int i, j, n=4, num =1;
		
		for(i=0;i<n;i++)
		{
			for(j=0;j<=i;j++) {
				System.out.print(num+ " ");
				
				num=num+1;
			}
			
			System.out.println();
		}
		
		
			

	}

}


