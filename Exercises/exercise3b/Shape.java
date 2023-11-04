package Exercises.exercise3b;

import java.io.Serializable;

public abstract class Shape implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String color = "Red";

    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    public void display() {
        System.out.println("This is a " + this.getClass().getSimpleName() + " with color: " + color);
    }
}