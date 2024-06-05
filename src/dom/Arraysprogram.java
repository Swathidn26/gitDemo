package dom;

public class Arraysprogram {

	public static void main(String[] args) {

		int arr[] = new int []{10,20,30,40,50};
		int n=1;
		
		
		for(int i =0;i<arr.length;i++) {
			System.out.println( arr[i]+ " ");
		}
		
		for(int i=0;i<n;i++) {
			int j, last;
			last = arr[arr.length-1];
			
			for(j=arr.length-1;j>0;j--) {
				arr[j]=arr[j-1];
			}
			arr[0]=last;
		}
		System.out.println("Right shift array: ");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+ " ");
		}
		
	}

}
