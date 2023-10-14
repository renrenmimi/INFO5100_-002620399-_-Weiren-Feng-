package Exercises.exercise0;

public class calendar {
    String type;
    String brand;
    int month;
    int year;
    int day;
    int holidays;
    String reminder;
    String season;
    String id;

    public calendar(String calendarId){
        this.id = calendarId;
        System.out.println("calendar " + this.id + " created");
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }

    public int getDay(){
        return this.day;
    }
}
