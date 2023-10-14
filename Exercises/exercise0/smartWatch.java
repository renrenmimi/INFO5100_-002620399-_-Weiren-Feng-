package Exercises.exercise0;

public class smartWatch {  
    String material;
    String bandType;
    String brand;
    int memoryRAM;
    String color;
    int apps;
    boolean phoneConnect;
    String time;
    String id;

    public smartWatch(String smartWatchId){
        this.id = smartWatchId;
        System.out.println("SmartWatch " + this.id + " created");
    }

    public void setApps(int appNumber){
        this.apps = appNumber;
    }

    public String getColor(){
        return this.color;
    }

    public int getMemory(){
        return this.memoryRAM;
    }
}
