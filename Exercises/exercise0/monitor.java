package Exercises.exercise0;

public class monitor {
    int size;
    String sizeUnit;
    boolean rotatable;
    int HDMIPorts;
    int USBPorts;
    boolean lightningPort;
    boolean status;
    String brand;
    String id;

    public monitor(String monitorId){
        this.id = monitorId;
        System.out.println("monitor " + this.id + " created");
    }

    public int getHPorts(){
        return this.HDMIPorts;
    }

    public int getUPorts(){
        return this.USBPorts;
    }

    public void closeMonitor(){
        this.status = false;
    }
}
