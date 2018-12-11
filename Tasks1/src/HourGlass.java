import java.util.Scanner;

public class HourGlass {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int [][] values  = new int[6][6];
		int max = Integer.MIN_VALUE;
		int temp;
		
		for (int i=0; i<6; i++) {
			for(int k=0; k<6; k++) {
				values [i][k] = input.nextInt();
			}
		}
		
		for (int i=0; i<3; i++) {
			for (int k=0; k<3; k++) {
				temp= values[i][k] + values[i][k+1] + values[i][k+2] + values[i+1][k+1] 
						+ values[i+2][k] + values[i+2][k+1] + values[i+2][k+2];
				max = Math.max(temp, max);
				
			}
		}
		
		System.out.println(max);
		input.close();
	}

}
