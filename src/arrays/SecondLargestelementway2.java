package arrays;

public class SecondLargestelementway2 {

	public static void main(String[] args) {
		
		int arr[] = {2,4,3,6,9,9};
		int temp;
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j = i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		}
//		System.out.println(arr.length);
//		System.out.println(arr[arr.length-1]);
		
		
		for(int i = arr.length-2;i>=0;i--)
			
		{
//			System.out.println(arr[i]);
			if(arr[i]!=arr[arr.length-1])
				
			{
				System.out.println(arr[i]);
				break;
			}
		}

	}
	

}
