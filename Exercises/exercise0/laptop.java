package Exercises.exercise0;

public class laptop {
    Keyboard keyboard;
    Speaker speakers;
    String brand;
    String size;
    String storage;
    String color;
    String price;
    Boolean status;
    String id;

    public laptop(String laptopId){
        this.id = laptopId;
        System.out.println("laptop " + this.id + " created");
    }

    public void setColor(String chooseColor){
        this.color = chooseColor;
    }

    public String getPrice(){
        return this.price;
    }

    public void setStorage(String chooseStorage){ 
        this.storage = chooseStorage;
    }

    public class Keyboard{
        String size;
        String brand;
        String type;

        public Keyboard(){

        }
    }

    public class Speaker{
        String brand;
        String price;

        public Speaker(){

        }
        
    }
    
}
