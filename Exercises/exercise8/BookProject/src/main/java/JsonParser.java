package Exercises.exercise8.BookProject.src.main.java;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public List<Book> readBooksFromJson(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jsonObject = new JSONObject(content);
        JSONArray bookShelf = jsonObject.getJSONArray("BookShelf");
        List<Book> books = new ArrayList<>();

        for (int i = 0; i < bookShelf.length(); i++) {
            JSONObject bookObject = bookShelf.getJSONObject(i);
            String title = bookObject.getString("title");
            int publishedYear = bookObject.getInt("publishedYear");
            int numberOfPages = bookObject.getInt("numberOfPages");
            JSONArray authorsJsonArray = bookObject.getJSONArray("authors");
            List<String> authors = new ArrayList<>();
            for (int j = 0; j < authorsJsonArray.length(); j++) {
                authors.add(authorsJsonArray.getString(j));
            }
            books.add(new Book(title, publishedYear, numberOfPages, authors));
        }

        return books;
    }

    public void addBookToJson(String filePath, Book book) throws IOException {
        File file = new File(filePath);
        String content = new String(Files.readAllBytes(file.toPath()));
        JSONObject jsonObject = new JSONObject(content);
        JSONArray bookShelf = jsonObject.getJSONArray("BookShelf");

        JSONObject newBookObject = new JSONObject();
        newBookObject.put("title", book.getTitle());
        newBookObject.put("publishedYear", book.getPublishedYear());
        newBookObject.put("numberOfPages", book.getNumberOfPages());
        JSONArray authorsJsonArray = new JSONArray(book.getAuthors());
        newBookObject.put("authors", authorsJsonArray);

        bookShelf.put(newBookObject);

        Files.write(Paths.get(filePath), jsonObject.toString(4).getBytes());
    }
}

