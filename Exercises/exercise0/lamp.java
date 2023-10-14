package Exercises.exercise0;
public class lamp{
    String brand;
    String size;
    String bulb;
    String price;
    String height;
    String cordLength;
    String shape;
    boolean status;
    String id;
    
    public lamp(String lampId){
        this.id = lampId;
        System.out.println("lamp " + this.id + " created");
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setBrand(String lampBrand){
        this.brand = lampBrand;
    }

    public void lampTurnedOn(){
        this.status = true;
    }
}