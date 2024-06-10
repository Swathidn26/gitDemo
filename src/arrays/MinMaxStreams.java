package arrays;

import java.util.Arrays;

public class MinMaxStreams {

	public static void main(String[] args) {
		
		int arr[] = {40,78,23,56,47,99,104,29,55};
		
		System.out.println("MIN ELEMENT : "  +MinMaxStreams.min(arr));
		
		System.out.println("MAX ELEMENT : "  +MinMaxStreams.max(arr));
	
	}
		
	static int min(int arr[]) {
		return Arrays.stream(arr).min().getAsInt();

	}
	
	static int max(int arr[])
	{
	return	Arrays.stream(arr).max().getAsInt();
	}
	

}

