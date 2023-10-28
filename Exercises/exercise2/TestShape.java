package Exercises.exercise2;
public class TestShape {
    public static void main(String[] args) {
        Shape triangle = new Triangle(3, 4, 5);
        Shape rectangle = new Rectangle(4, 5);
        Shape circle = new Circle(7);
        Shape square = new Square(4);

        // Polymorphism in action
        Shape[] shapes = {triangle, rectangle, circle, square};
        for (Shape shape : shapes) {
            shape.display();
            System.out.println("Area: " + shape.calculateArea());
            System.out.println("Perimeter: " + shape.calculatePerimeter());
            System.out.println();
        }
    }
}