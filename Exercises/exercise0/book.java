package Exercises.exercise0;

public class book {
    String color;
    String title;
    String size;
    String price;
    String author;
    String publisher;
    int pages;
    boolean bookMark;
    String id;

    public book(String bookId){
        this.id = bookId;
        System.out.println("book " + this.id + " created");
    }



    public void addMark(){
        this.bookMark = true;
    }

    public void addcolor(String bookcolor){
        this.color = bookcolor;
    }

    public String getPrice(){
        return this.price;
    }

}
