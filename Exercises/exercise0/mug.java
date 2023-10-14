package Exercises.exercise0;

public class mug {
    String unit;
    String brand;
    String material;
    String color;
    String price;
    String shape;
    String weight;
    int volume;
    String id;

    public mug(String mugId){
        this.id = mugId;
        System.out.println("mug " + this.id + " created");
    }

    public void setBrand(String mugBrand){
        this.brand = mugBrand;
    }

    public void setVolume(int mugVolume){
        this.volume = mugVolume;
    }

    public String getPrice(){
        return price;
    }
  
}
