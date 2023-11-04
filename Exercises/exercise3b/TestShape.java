package Exercises.exercise3b;

import java.io.IOException;

public class TestShape {
    public static void main(String[] args) {
        Shape square = new Square(4);

        // Display shape info and test polymorphism
        square.display();
        System.out.println("Area: " + square.calculateArea());
        System.out.println("Perimeter: " + square.calculatePerimeter());
        System.out.println();

        // Serialization and deserialization test file name
        String fileName = "shape.ser";

        // Test serialization and deserialization process
        try {
            // Serialize object
            SerializationUtil.serialize(square, fileName);
            System.out.println("Serialization of Square is done.");

            // Deserialize object
            Square savedSquare = (Square) SerializationUtil.deserialize(fileName);
            System.out.println("Deserialization of Square is done.");

            // Display deserialized object info
            savedSquare.display();
            System.out.println("Area: " + savedSquare.calculateArea());
            System.out.println("Perimeter: " + savedSquare.calculatePerimeter());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}