package arrays;

public class MaxandMininarray {

	public static void main(String[] args) {
		
		int arr[] = {40,78,23,56,47,99,104,29,55};
		int size = arr.length;
		int temp;
		
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
		
	System.out.println("Min  " +arr[0]+ "\n"+  "MAX "  +arr[size-1]);	
	}

}
