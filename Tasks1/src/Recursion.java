import java.util.*;

public class Recursion {

	private static Scanner s;
	
	public static void main(String[] args) {
		
		int num;
		int factorial;
        s = new Scanner(System.in);
        System.out.print("Enter any integer:");
        num = s.nextInt();
        Recursion obj = new Recursion();
        factorial = obj.fact(num);
        System.out.println("Factorial of "+num+" is : "+factorial);
    }
	
	int fact(int x)
    {
        if(x>1)
        {
            return(x * fact(x-1));
        }
        return 1;
    }
		
	
	}