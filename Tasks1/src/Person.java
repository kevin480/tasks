import java.util.*;

public class Person {
    private int age;	
  
	public Person(int initialAge) {
			
          if (initialAge >= 0) {
            age = initialAge;
        } 
        else {
            System.out.println("Age is not valid, setting age to 0.");
            age = 0;
        }
	}

	
	public void amIOld() {
        String output;
        if (age < 13) {
            output = "You are young.";
        }
        else if (age < 18) {
            output = "You are a teenager.";
        }
        else {
            output = "You are old.";
        }
       
        System.out.println(output);
    }
	public void yearPasses() {
  		
        age++;
	}

    public static void main(String[] args) {
    	
    	
		Scanner sc = new Scanner(System.in);
     
		System.out.println("Enter the number of ages to be verified");
		int n= sc.nextInt();
		System.out.println("enter the ages now");
		for (int i = 1; i <=n ; i++)
		{
			int age = sc.nextInt();
			Person p = new Person(age);
			p.amIOld();
	
        }
		sc.close();
    }
}