package Exercises.exercise0;

public class fan {
    String material;
    String brand;
    String size;
    String color;
    String price;
    int blades;
    int speed;
    boolean status;
    String id;

    public fan(String fanId){
        this.id = fanId;
        System.out.println("fan " + this.id + " created");
    }

    public void fanTurnedOn(){
        this.status = true;
    }

    public void setBrand(String fanBrand){
        this.brand = fanBrand;        
    }
    
    public int getSpeed(){
        return this.speed;
    }
}
