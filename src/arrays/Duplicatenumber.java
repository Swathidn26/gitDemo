package arrays;

public class Duplicatenumber {

	public static void main(String[] args) {
		
		
		int arr[] = {1,2,3,5,6,2,8,66,99,45,34,78,1,4,6,99};
		
		System.out.println("Duplicate number in an array : ");
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					System.out.println(arr[j]);
				}
			}
		}
	}

}
