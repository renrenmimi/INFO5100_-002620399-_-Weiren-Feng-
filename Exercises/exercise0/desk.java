package Exercises.exercise0;

public class desk {
    String height;
    String length;
    String width;
    String brand;
    int drawers;
    String material;
    String color;
    String price;
    String id;

    public desk(String deskId){
        this.id = deskId;
        System.out.println("desk " + this.id + " created");
    }

    public String getPrice(){
        return this.price;
    }

    public int getDrawers(){
        return this.drawers;
    }

    public void setColor(String whatColor){
        this.color = whatColor;
    }

}
