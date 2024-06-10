package arrays;

public class SecondLargestEle2 {

	public static void main(String[] args) {
		
		int arr[] = {10,34,25,77,68,77};
		
		int temp,size;
		size = arr.length;
		
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
		System.out.println(arr[i]);
		}
		System.out.println("Second largest number is " +arr[size-2]);

	}

}
