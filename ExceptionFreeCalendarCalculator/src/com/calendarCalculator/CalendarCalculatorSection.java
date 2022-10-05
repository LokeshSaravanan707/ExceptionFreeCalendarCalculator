package com.calendarCalculator;
public class CalendarCalculatorSection {
    public static boolean isLeapYear(int year){
        return (year % 400) == 0 || (year % 4) == 0 && (year % 100) != 0;
    }
    public static int monthInDays(boolean isLeapYear,int months) {
        int daysLimit;
        if (months == 1 || months == 3 || months == 5 || months == 7
                || months == 8 || months == 10 || months == 12) {
            daysLimit = 31;
        } else if (months == 4 || months == 6 || months == 9 || months == 11) {
            daysLimit = 30;
        } else if (isLeapYear && months == 2) {
            daysLimit = 29;
        } else daysLimit = 28;
        return daysLimit;
    }
    public static int checkWeeksOddDays(int weekValue){
        if(weekValue>=7) {
            int dividedvalue = weekValue / 7;
            int multipliedValue = dividedvalue * 7;
            int count = 0;
            while (multipliedValue < weekValue) {
                count++;
                multipliedValue++;
            }
            weekValue = count;
        }
        return weekValue;
    }
    public static int oddDaysInYear(int year){
        int numberOfOddDays1= 0;
        int yearsOddDay=0;
        int count = 1;
        while (yearsOddDay<=year){
            yearsOddDay+=400;
            count++;
        }
        if(count>1) {
            yearsOddDay -= 400;
        }
        count=1;
        while (yearsOddDay<=year){
            yearsOddDay+=100;
            numberOfOddDays1+=5;
            count++;
        }
        if(count>1) {
            yearsOddDay -= 100;
            numberOfOddDays1 -= 5;
        }
        numberOfOddDays1= checkWeeksOddDays(numberOfOddDays1);
        yearsOddDay = year - yearsOddDay;
        int numberOfOddDays2 = 0;
        for (int i=1;i<=yearsOddDay;i++) {
            boolean checkLeapYear=isLeapYear(i);
            if(checkLeapYear)numberOfOddDays2+=2;
            else numberOfOddDays2++;
        }
        numberOfOddDays2= checkWeeksOddDays(numberOfOddDays2);
        int numberOfOddDays = numberOfOddDays1 + numberOfOddDays2;
        numberOfOddDays= checkWeeksOddDays(numberOfOddDays);
        return numberOfOddDays;
    }
    public static int oddDaysInMonths(int year,int month,int date){
        int days = 0;
        for (int i=1;i<=month;i++){
            days += monthInDays(isLeapYear(year),i);
        }
        return checkWeeksOddDays(days+date);
    }

    public static String daysOutput (int oddDays1,int oddDays2){
        int sum = oddDays1 + oddDays2;
        int totalOutput = checkWeeksOddDays(sum);
        return ExceptionEleminatorSection.days[totalOutput];
    }
}