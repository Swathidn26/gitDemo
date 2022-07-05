package dom;

public class Arraysprogram {

	public static void main(String[] args) {

		int arr[] = {10,20,30,40,50};
		int n=2;
		
		
		for(int i =0;i<arr.length;i++) {
			System.out.println("original array" +arr[i]);
		}
		
		for(int i=0;i<n;i++) {
			int j, last;
			last = arr[arr.length-1];
			
			for(j=arr.length-1;j>0;j--) {
				arr[j]=arr[j-1];
			}
			arr[0]=last;
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("Right shift of array" +arr[i]);
		}
		
	}

}
