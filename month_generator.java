import java.util.Scanner;

public class month_generator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int year = input.nextInt();
		int leap_year = leap(year);
		
		System.out.print(leap_year);

	}
	
	public static int leap(int year) {
		if(year%4 != 0) {
			return 0;
		}else if(year%100 != 0) {
			return 1;
		}else if(year%400!=0) {
			return 0;
		}else {
			return 1;
		}
	}

}
