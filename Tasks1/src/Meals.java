import java.util.*;
 public class Meals {
	 
 	private static Scanner m1;

	public static void main(String[] args) {
		
		double mealCost;
		int tipPercentage;
		int taxPercentage;
		
		m1 = new Scanner(System.in);
		System.out.println("enter the meal amount");	
		mealCost = m1.nextDouble();
		System.out.println("enter the tip amount");
		tipPercentage = m1.nextInt();
		System.out.println("enter the tax amount");
		taxPercentage = m1.nextInt();
		
		double tip = mealCost*((double)tipPercentage/100);
		double tax = mealCost*((double)taxPercentage/100);
		double totalCost= mealCost+tip+tax;
		
		System.out.println("the total cost of a meal in dollars is "+Math.round(totalCost)+" dollars");

		m1.close();
	}
 }
