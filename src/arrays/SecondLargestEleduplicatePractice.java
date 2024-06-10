package arrays;

public class SecondLargestEleduplicatePractice {

	public static void main(String[] args) {

		int arr []= {10,55,43,78,45,67,78};

		int largest = Integer.MIN_VALUE;
		int secondlargest = Integer.MIN_VALUE;

		for(int i = 0;i < arr.length;i++)
		{
			if(arr[i]>largest)
			{
				secondlargest = largest;
				largest = arr[i];
			}
			else if (arr[i]>secondlargest && arr[i]!=largest)
			{
				secondlargest = arr[i];
			}
		}
		if(secondlargest==Integer.MIN_VALUE)
		{
			System.out.println("no second largest element found ");
		}
		else
		{
			System.out.println("Second largest element is : " +secondlargest);
		}

	}

}
