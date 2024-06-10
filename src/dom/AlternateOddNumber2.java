package dom;
import java.util.ArrayList;

public class AlternateOddNumber2 {





	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<Integer> bl = new ArrayList<Integer>();
		for(int i=1;i<100;i++)
		{
			if(i%2!=0)
			{
				al.add(i);
			}
			else
			{
				bl.add(i);
			}
		}
		System.out.println(al);
		System.out.println(bl);
}

}

