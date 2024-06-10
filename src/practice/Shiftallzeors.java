package practice;

import java.util.Arrays;

public class Shiftallzeors {
	
	
	
	
	public static int [] shiftingzeros(int [] a)
	{
		if(a.length==1)
		{
			return a;
		}
		
		int arr[] = new int[a.length];
		int count =0 ;
		
		for(int i =0;i<a.length;i++)
		{
			if(a[i]!=0)
			{
				arr[count]= a[i];
				count++;
			}
		}
		return arr;
		
		
		
	}

	public static void main(String[] args) {
		
		int arr []= {1,0,6,0,0,4,5,6,0,5,3,2};
		
		System.out.println(Arrays.toString(Shiftallzeors.shiftingzeros(arr)));
		
		
		
	}

}
