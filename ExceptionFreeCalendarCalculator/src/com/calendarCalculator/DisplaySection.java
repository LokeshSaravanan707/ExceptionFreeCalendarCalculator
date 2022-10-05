package com.calendarCalculator;
public class DisplaySection {
    public static void displayUsersAnswer(){
        System.out.println("This is a project, which produce exception free Calendar calculation");
        while (true){
            System.out.println();
            System.out.println("""
                    press 1 : To find, what was the Day of the week\s
                    press 2 : To find, number of days in that month\s
                    press 3 : To find, exact days on the month\s""".indent(2));
            System.out.println("Enter the value between 1 to 3 as per your query");
            int value = ExceptionEleminatorSection.integerCheck(1,3,"3","Value");
            System.out.println();
            switch (value) {
                case 1 -> {
                    int yearOutput = ExceptionEleminatorSection.integerCheck(9, 999999999,
                            "999_999_999", "YEAR");
                    int monthOutput = ExceptionEleminatorSection.integerCheck(2, 12,
                            "12", "MONTH");
                    boolean leapYear = CalendarCalculatorSection.isLeapYear(yearOutput);
                    int dayLimit = CalendarCalculatorSection.monthInDays(leapYear, monthOutput);
                    int dateOutput = ExceptionEleminatorSection.integerCheck(2, dayLimit, Integer.toString(dayLimit), "DATE");
                    int oddDays1 = CalendarCalculatorSection.oddDaysInYear(yearOutput - 1);
                    int oddDays2 = CalendarCalculatorSection.oddDaysInMonths(1, monthOutput - 1, dateOutput);
                    System.out.println();
                    System.out.println("The output for your query is : "+
                            CalendarCalculatorSection.daysOutput(oddDays1, oddDays2));
                }
                case 2 -> {
                    int yearOutput = ExceptionEleminatorSection.integerCheck(9, 999999999,
                            "999_999_999", "YEAR");
                    int monthOutput = ExceptionEleminatorSection.integerCheck(2, 12,
                            "12", "MONTH");
                    boolean leapYear = CalendarCalculatorSection.isLeapYear(yearOutput);
                    int dayLimit = CalendarCalculatorSection.monthInDays(leapYear, monthOutput);
                    System.out.println();
                    System.out.println("Your output is... ");
                    for (int i = 1; i <= dayLimit; i++) {
                        int oddDays1 = CalendarCalculatorSection.oddDaysInYear(yearOutput - 1);
                        int oddDays2 = CalendarCalculatorSection.oddDaysInMonths(1,
                                monthOutput - 1, i);
                        System.out.println(" " + i + "." + monthOutput + "." + yearOutput + " is " +
                                CalendarCalculatorSection.daysOutput(oddDays1, oddDays2));
                    }
                }
                case 3 -> {
                    int yearOutput = ExceptionEleminatorSection.integerCheck(9, 999999999,
                            "999_999_999", "YEAR");
                    int monthOutput = ExceptionEleminatorSection.integerCheck(2, 12,
                            "12", "MONTH");
                    String weekOutput = ExceptionEleminatorSection.stringCheck(9);
                    boolean leapYear = CalendarCalculatorSection.isLeapYear(yearOutput);
                    int dayLimit = CalendarCalculatorSection.monthInDays(leapYear, monthOutput);
                    System.out.println();
                    System.out.println("Your output is... ");
                    for (int i = 1; i <= dayLimit; i++) {
                        int oddDays1 = CalendarCalculatorSection.oddDaysInYear(yearOutput - 1);
                        int oddDays2 = CalendarCalculatorSection.oddDaysInMonths(1,
                                monthOutput - 1, i);
                        if(CalendarCalculatorSection.daysOutput(oddDays1, oddDays2).equals(weekOutput) )
                            System.out.println(" " + i + "." + monthOutput + "." + yearOutput + " is " +
                                    CalendarCalculatorSection.daysOutput(oddDays1, oddDays2));
                    }
                }
            }
            String quitStatement = ExceptionEleminatorSection.stringCheck(3);
            if(quitStatement.equals("NO")) {
                System.out.println("You where quit!!!");
                break;
            }
        }
    }
}
