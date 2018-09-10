import java.util.*;

public class Reverse {

	private static Scanner a1;

	public static void main(String[] args) 
	{

		int a[];
		System.out.println("Enter the Size of the array");
		
		a1 = new Scanner(System.in);
		int Size = a1.nextInt();
		a = new int[Size];
		for (int i=0; i<Size; i++)
		{
			a[i] = a1.nextInt();
		}
		for (int i= Size-1; i>=0;i--)		
		{
			System.out.print(a[i]+" ");
		}
		
	}

}