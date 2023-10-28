package Exercises.exercise2;
public abstract class Shape {
    protected static String color = "Red";

    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    public void display() {
        System.out.println("This is a " + this.getClass().getSimpleName() + " with color: " + Shape.color);
    }
}