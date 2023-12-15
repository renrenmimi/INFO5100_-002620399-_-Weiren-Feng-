package Exercises.exercise8.BookProject.src.main.java;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {
    public List<Book> readBooksFromXml(String filePath) throws Exception {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        List<Book> books = new ArrayList<>();
        NodeList nList = doc.getElementsByTagName("Book");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                int publishedYear = Integer.parseInt(eElement.getElementsByTagName("publishedYear").item(0).getTextContent());
                int numberOfPages = Integer.parseInt(eElement.getElementsByTagName("numberOfPages").item(0).getTextContent());

                List<String> authors = new ArrayList<>();
                NodeList authorsList = eElement.getElementsByTagName("author");
                for (int count = 0; count < authorsList.getLength(); count++) {
                    Node node1 = authorsList.item(count);
                    if (node1.getNodeType() == node1.ELEMENT_NODE) {
                        Element author = (Element) node1;
                        authors.add(author.getTextContent());
                    }
                }

                books.add(new Book(title, publishedYear, numberOfPages, authors));
            }
        }
        return books;
    }

    public void addBookToXml(String filePath, Book book) throws Exception {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        Element rootElement = doc.getDocumentElement();

        // Create Book element
        Element newBook = doc.createElement("Book");
        rootElement.appendChild(newBook);

        // Create and append Title element
        Element title = doc.createElement("title");
        title.appendChild(doc.createTextNode(book.getTitle()));
        newBook.appendChild(title);

        // Create and append PublishedYear element
        Element publishedYear = doc.createElement("publishedYear");
        publishedYear.appendChild(doc.createTextNode(Integer.toString(book.getPublishedYear())));
        newBook.appendChild(publishedYear);

        // Create and append NumberOfPages element
        Element numberOfPages = doc.createElement("numberOfPages");
        numberOfPages.appendChild(doc.createTextNode(Integer.toString(book.getNumberOfPages())));
        newBook.appendChild(numberOfPages);

        // Create and append Authors element
        Element authors = doc.createElement("authors");
        newBook.appendChild(authors);
        for (String authorName : book.getAuthors()) {
            Element author = doc.createElement("author");
            author.appendChild(doc.createTextNode(authorName));
            authors.appendChild(author);
        }

        // Write changes to XML file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(xmlFile);
        transformer.transform(source, result);
    }
}

