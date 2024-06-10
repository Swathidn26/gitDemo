package arrays;

public class SecondLargetsele {

	public static void main(String[] args) {
		
		int [] arr = {1,4,3,2,9,7};
		int first =0;
		int second = 0;
		int n=arr.length;
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]>first)
			{
				second = first;
				first = arr[i];
			}
		}
		System.out.println("first largest" +first+ " Second Largest " +second);
	}

}
