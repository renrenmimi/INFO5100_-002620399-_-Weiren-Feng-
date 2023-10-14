package Exercises.exercise0;

public class phone {
    String phoneBrand;
    String size;
    int camera;
    int buttons;
    String batteryLife;
    boolean silentMode;
    int apps;
    String phoneCarrier;
    String id;

    public phone(String phoneId){
        this.id = phoneId;
        System.out.println("phone " + this.id + " created");
    }

    public int getApps(){
        return this.apps;
    }
    
    public void setCarrier(String newCarrier){
        this.phoneCarrier = newCarrier;
    }

    public int getButtons(){
        return this.buttons;   
    }
}
