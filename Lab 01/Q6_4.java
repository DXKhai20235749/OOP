import java.util.Scanner;

public class Q6_4 {
    public static void main(String[] args) {
        Scanner ynm = new Scanner(System.in);
        int year;
        int month = -1;
        System.out.println("Enter year: ");
        while (true) {
        	
            year = ynm.nextInt();
            if (year >= 0) break;
            else System.out.println("Please enter the year again, the year should be a positive integer:");
        }
        
        ynm.nextLine();
        System.out.println("Enter month: ");
        while (true) {
            String input = ynm.nextLine().trim();
            month = MonthToNumberForm(input);
            if (month == -1) {
                System.out.println("Please enter the month again (in name, abbreviation, or number): ");
            } else {
                break;
            }
        }
        
        int day = MonthToDay(month, year);
        System.out.println("Days in Month according to your input: " + day + ".");
        
        ynm.close();
    }

    private static int MonthToNumberForm(String input) {
        switch (input) {
            case "January": case "Jan.": case "Jan": case "1": return 1;
            case "February": case "Feb.": case "Feb": case "2": return 2;
            case "March": case "Mar.": case "Mar": case "3": return 3;
            case "April": case "Apr.": case "Apr": case "4": return 4;
            case "May": case "5": return 5;
            case "June": case "Jun.": case "Jun": case "6": return 6;
            case "July": case "Jul.": case "Jul": case "7": return 7;
            case "August": case "Aug.": case "Aug": case "8": return 8;
            case "September": case "Sep.": case "Sep": case "9": return 9;
            case "October": case "Oct.": case "Oct": case "10": return 10;
            case "November": case "Nov.": case "Nov": case "11": return 11;
            case "December": case "Dec.": case "Dec": case "12": return 12;
            default: return -1;
        }
    }

    private static int MonthToDay(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
    }
}
