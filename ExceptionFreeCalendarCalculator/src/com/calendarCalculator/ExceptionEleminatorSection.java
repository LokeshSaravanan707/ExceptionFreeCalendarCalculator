package com.calendarCalculator;
import java.util.Scanner;
public class ExceptionEleminatorSection {
    static Scanner scan = new Scanner(System.in);
    static String[] monthsString = new String[]{"JANUARY","FEBRUARY","MARCH",
            "APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER",
            "NOVEMBER","DECEMBER" };
    static String[] days = new String[]{"SUNDAY","MONDAY","TUESDAY","WEDNESDAY",
            "THURSDAY","FRIDAY","SATURDAY"};
    static String[] quitString = new String[]{"YES", "NO"};
    public static int integerCheck(int length, int limit, String limitDisplay, String parameter) {
        int inputInteger = 0;
        int count = 0;
        String input;
        while (true) {
            System.out.print("Enter the "+parameter+" : ");
            input = scan.next();
            if (parameter.equals("MONTH") && input.length()>length && input.length()<=8){

                String checkMonth = input.toUpperCase();
                for(int i=0;i<12;i++){
                    if(checkMonth.equals(monthsString[i])){
                        inputInteger = ++i;
                        count++;
                        break;
                    }
                }
                if(count==1) break;
                else {
                    System.out.println("Please enter the " + parameter + " between 1 to "
                            + limitDisplay + " or January to December " );
                    continue;
                }
            }
            else {
                if(input.length()>length){
                    if (parameter.equals("MONTH")){
                        System.out.println("Please enter the " + parameter + " between 1 to "
                                + limitDisplay + " or January to December " );
                    }else {
                        System.out.println("Please enter the " + parameter + " between 1 to " + limitDisplay);
                    }
                    continue;
                }
            }

            char[] inputchar = input.toCharArray();
            int i;
            for (i = 0; i < input.length(); i++) {
                boolean c = ((int) inputchar[i] >= 48) && ((int) inputchar[i] <= 57);
                if (!c){
                    if (parameter.equals("MONTH")){
                        System.out.println("Please enter the " + parameter + " between 1 to "
                                + limitDisplay + " or January to December " );
                    }else {
                        System.out.println("Please enter the " + parameter + " between 1 to " + limitDisplay);
                    }
                    break;
                }
            }
            if (i >= (input.length()) && i <= (input.length())){
                inputInteger=Integer.parseInt(input);
                if(inputInteger<=limit && inputInteger !=0){
                    break;
                }
                if (parameter.equals("MONTH")){
                    System.out.println("Please enter the " + parameter + " between 1 to "
                            + limitDisplay + " or January to December " );
                }else {
                    System.out.println("Please enter the " + parameter + " between 1 to " + limitDisplay);
                }
            }
        }
        return inputInteger;
    }
    public static String stringCheck (int limit){
        String outputString = null;
        if(limit == 3) {
            System.out.println();
            System.out.print("Enter 'YES' to continue or 'NO' to quit : ");
        }
        else System.out.print("Enter day between 'SUNDAY' to 'SATURDAY' : ");
        int i ;
        while (true) {
            String input = scan.next().toUpperCase();
            if(limit==3){
                if (input.length() > limit) {
                    System.out.print("Please enter 'YES' to continue or 'NO' to quit : ");
                    continue;
                }
                for (i = 0; i < quitString.length; i++) {
                    if (input.equals(quitString[i])) {
                        outputString = quitString[i];
                        break;
                    }
                }
                if (i >= 2)
                    System.out.print("Please enter 'YES' to continue or 'NO' to quit : ");
                else break;
            }
            else
            {
                if(input.length() > 9){
                    System.out.print("Please enter day between 'SUNDAY' to 'SATURDAY' : ");
                    continue;
                }
                for(i = 0; i < days.length; i++){
                    if (input.equals(days[i])) {
                        outputString = days[i];
                        break;
                    }
                }
                if (i >= 7)
                    System.out.print("Please enter day between 'SUNDAY' to 'SATURDAY' : ");
                else break;
            }
        }
        return outputString;
    }
}
