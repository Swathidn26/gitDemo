package arrays;

public class MaxConsecitivesOnesExample {

	public static void main(String[] args) {
		
		int [] arr = {1,1,0,0,1,1,1,0,0,0,1,1,1,1,1};
		
		int count = 0;
		int max = 0;
//		System.out.println(arr.length);
		for(int i=0;i<arr.length;i++)
		{
			while(i<arr.length && arr[i]==1)
			{
				count++;
				i++;
			}
			if(max<count)
			{
				max= count;
			}
			count = 0;
		}
		
		
		
		System.out.println(max);
		
		
		
	}
}