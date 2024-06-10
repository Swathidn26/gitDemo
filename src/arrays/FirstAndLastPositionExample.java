package arrays;

public class FirstAndLastPositionExample {

	public static void main(String[] args) {
		
		int arr []  = {5,7,7,8,8,10};
		
		int firstindex = -1;
		int lastindex = -1;
		
		int target = 8;
		
		for(int i =0;i<arr.length;i++)
		{
			if(arr[i]== target && firstindex == -1)
			{
				firstindex = i;
			}
			if(arr[i]== target &&firstindex!= -1)
			{
				lastindex = i;
			}
		}
		System.out.println("FIRST INDEX " +firstindex + " LAST INDEX " + lastindex);

	}

}
