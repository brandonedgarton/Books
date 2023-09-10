import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class csv {
    static ArrayList<Book> books;
    static LinkedList booksLinked;

public static void readFile() {
books = new ArrayList<>();
booksLinked = new LinkedList();
	String file = "C:\\Users\\Damian\\Downloads\\books.csv";
    String line = "";
    String splitBy = ",";

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {

        br.readLine(); // Skip the header
     
        while ((line = br.readLine()) != null) {
            String[] data = line.split(splitBy);
            String authors = "-";
            String isbn = "-"; 
            int bookId = 0;
            int originalPublicationYear = 0000;
            String title = "-";
            String languageCode = "-";
            double averageRating = 0.0;
            int ratingsCount = 0;
            String imageUrl = "-";
            
            int booknum = Integer.parseInt(data[0]);
            try {
            	authors = data[7].trim();
            } catch (Exception e) {
            }
            try {
             bookId = Integer.parseInt(data[1]);
            } catch (Exception e) {
            }
            try {
             isbn = data[5];
            } catch (Exception e) {
            }
            try {
             originalPublicationYear = Integer.parseInt(data[8]);
            } catch (Exception e) {
            }
            try {
             title = data[10];
            } catch (Exception e) {
            }
            try {
             languageCode = data[11];
            } catch (Exception e) {
            }
            try {
             averageRating = Double.parseDouble(data[12]);
            } catch (Exception e) {
            }
            try {
             ratingsCount = Integer.parseInt(data[14]);
            } catch (Exception e) {
            }
            try {
             imageUrl = data[21];
            } catch (Exception e) {
            }
            Book currBook = new Book(booknum, bookId, isbn, authors, originalPublicationYear, title, languageCode, averageRating, ratingsCount, imageUrl);
            
            booksLinked.add(currBook);
            books.add(currBook);

        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


public static Book getBooks(int x) {
	return books.get(x);
}

public static ArrayList getAllBooksArray() {
	return books;
	
	}

public static LinkedList getAllBooksLinked() {
	return booksLinked;
	
	}

}











