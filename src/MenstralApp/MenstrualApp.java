package MenstralApp;

import java.time.LocalDate;
import java.util.Scanner;

public class MenstrualApp {
    Scanner scanner = new Scanner(System.in);
    LocalDate date = LocalDate.now();
    private final int[] month ={31,28,31,30,31,30,31,31,30,31,30,31};
    private int lastFlowYear;
    private int lastFlowMonth;
    private int lastFlowDay;
    private int nextFlowDay;
    private int nextFlowMonth;
    private int nextFlowYear;
    private int nextFlowStopYear;
    private int nextFlowStopMonth;
    private int nextFlowStopDay;
    private int yearOfBirth;
    private String userName;
    private String gender;
    public int flow;
    public MenstrualApp(int lastFlowYear, int lastFlowMonth, int lastFlowDay){
        this.lastFlowDay = lastFlowDay;
        this.lastFlowMonth = lastFlowMonth;
        this.lastFlowYear = lastFlowYear;
    }
    public void setLastFlowYear(int lastFlowYear){
        if(lastFlowYear > date.getYear()){
            while(lastFlowYear > date.getYear()){
                System.out.println("Please enter a valid year!!");
                lastFlowYear= scanner.nextInt();
            }
            this.lastFlowYear = lastFlowYear;
        }
    }
    public int getLastFlowYear(){
        return lastFlowYear;
    }
    public void setLastFlowDay(int lastFlowDay){
        while (lastFlowDay < 1 || lastFlowDay > month[getLastFlowMonth()-1]){
            System.out.println("please enter a valid month");
        }
        this.lastFlowDay = lastFlowDay;
    }
    public int getLastFlowDay(){
        return lastFlowDay;
    }
    public void setLastFlowMonth(int lastFlowMonth) {
        while(lastFlowMonth < 1 || lastFlowMonth > month.length){
            System.out.println("Please enter a valid month of your last flow");
        }
        this.lastFlowMonth = lastFlowMonth;
    }
    public int getLastFlowMonth(){
        return lastFlowMonth;
    }
    public void setNextFlowDay(){

    }
}
