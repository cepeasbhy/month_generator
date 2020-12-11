import java.util.Scanner;

public class month_generator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("MONTH GENERATOR");
		System.out.println("---------------");
		
		System.out.print("Enter year: ");
		int year = input.nextInt();
		
		System.out.println("Select a month: ");
		System.out.println("[1] JANUARAY     [7] JULY");
		System.out.println("[2] FEBRUARY     [8] AUGUST");
		System.out.println("[3] MARCH        [9] SEPTEMBER");
		System.out.println("[4] APRIL        [10] OCTOBER");
		System.out.println("[5] MAY          [11] NOVEMBER");
		System.out.println("[6] JUNE         [11] DECEMBER");
		System.out.print("Enter you choice: ");
		int month  = input.nextInt();
		
		int yearcode = year_code(year);
		int leap_year = leap(year);
		
	}
	
	public static int year_code(int year) {
		int last = year%100;
		return (last+(last/4))%7;
	}
	
	public static int leap(int year) {
		if(year%4 != 0) {
			return 0;
		}else if(year%100 != 0) {
			return 1;
		}else if(year%400 != 0) {
			return 0;
		}else {
			return 1;
		}
	}

}
