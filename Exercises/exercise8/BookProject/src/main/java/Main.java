package Exercises.exercise8.BookProject.src.main.java;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            XmlParser xmlParser = new XmlParser();
            JsonParser jsonParser = new JsonParser();

            String xmlFilePath = "src/resources/books.xml";
            String jsonFilePath = "src/resources/books.json";

            System.out.println("Books from XML:");
            xmlParser.readBooksFromXml(xmlFilePath).forEach(System.out::println);

            System.out.println("\nBooks from JSON:");
            jsonParser.readBooksFromJson(jsonFilePath).forEach(System.out::println);

            Book newBook = new Book("Effective Java", 2008, 384, Arrays.asList("Joshua Bloch"));
            xmlParser.addBookToXml(xmlFilePath, newBook);
            jsonParser.addBookToJson(jsonFilePath, newBook);

            System.out.println("\nUpdated Books from XML:");
            xmlParser.readBooksFromXml(xmlFilePath).forEach(System.out::println);

            System.out.println("\nUpdated Books from JSON:");
            jsonParser.readBooksFromJson(jsonFilePath).forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
