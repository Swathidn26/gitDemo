package practice;

public class SecondLargestNum {

	public static void main(String[] args) {
		
		int arr []  = {10,45,23,78,66,43,90,37,102,89};
		
		int temp;
		int size = arr.length;
		
		
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
		System.out.println("Second largest element: "  +arr[size-2]);
	}

}
