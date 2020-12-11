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
		
		/*System.out.println("Select the first day of the month: ");
		System.out.println("[1] SUNDAY     [5] THURSDAY");
		System.out.println("[2] MOMDAY     [6] FRIDAY");
		System.out.println("[3] TUESDAY    [7] SATURDAY");
		System.out.println("[4] WEDNESDAY");
		System.out.print("Enter you choice: ");
		int day = input.nextInt();
		*/
		int yearcode = year_code(year);
		int leap_year = leap(year);
		
		int monthcode = month_code(month-1);
		int centcode = cent_code(year);
		int daycode = (yearcode+monthcode+centcode+1-leap_year)%7;
		
		System.out.println("SU   MO   TU   WE   TH   FR   SA");
		if(month == 2) {
			if(leap_year == 1) {
				month_print(30, daycode+1);
			}else {
				month_print(30, daycode+1);
			}
		}else if(month%2 == 0 || month == 7) {
			month_print(31, daycode+1);
		}else {
			month_print(30, daycode+1);
		}
	}
	
	public static void month_print(int total_days, int day) {
		int ctr = 1, days = 1, j =1, row =1;
		
		for(int i = 0; i<row; i++) {
			for(; j!=total_days; j++) {
				if(day>j) {
					System.out.print("     ");
				}else {
					if(days<10) {
						System.out.print("0"+days+"   ");
					}else {
						System.out.print(days+"   ");
					}
					days++;
				}
				ctr++;
				if(ctr==8) {
					break;
				}
			}
			System.out.println();
			if(ctr != 8) {
				break;
			}else {
				ctr = 1;
				row++;
			}
		}
	}
	
	public static int cent_code(int year) {
		int[] code = {4,2,0,6,4,2,0};
		int k = 0, temp = 0;
		year /= 100;
		
		for(int i = 17; i<=23; i++) {
			if(year==i) {
				temp = code[k];
				break;
			}
			k++;
		}
		
		return temp;
	}
	
	public static int month_code(int month) {
		int[] code = {0,3,3,6,1,4,6,2,5,0,3,5};
		return code[month];
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
