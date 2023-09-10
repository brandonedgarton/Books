import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SearchandSort {
    private static class BookComparator implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            // Compare books based on booknum
            return Integer.compare(book1.getBooknum(), book2.getBooknum());
        }
    }

    public static void searchbyID(int id) throws IOException {
        // LinkedList books = csv.getAllBooksLinked();
        ArrayList<Book> books = csv.getAllBooksArray();


        Collections.sort(books, new BookComparator());

        // binary search
        int index = Collections.binarySearch(books, new Book(id, 0, null, null, 0, null, null, 0.0, 0, null), new BookComparator());

        if (index >= 0) {
            framewindow.populateFields(id);
        } else {
            System.out.println("Not found");
        }
    }

    public static int searchbyISBN(String isbn) {
        LinkedList<Book> books = csv.getAllBooksLinked();
        // ArrayList<Book> books = csv.getAllBooksArray();
        int found = -1;
        for (int i = 0; i < books.size(); i++) {
            Book currBook = books.get(i);
            if (currBook.getIsbn().equals(isbn)) {
                found = i;
                break;
            }
        }
        return found;
    }

    public static ArrayList<Integer> top10() {
        LinkedList<Book> books = csv.getAllBooksLinked();
        
        Comparator<Book> ratingComparator = (book1, book2) -> Double.compare(book2.getRating(), book1.getRating());
        Collections.sort(books, ratingComparator);
        
        ArrayList<Integer> topten = new ArrayList<Integer>(); 
        
        for (int i = 0; i < Math.min(10, books.size()); i++) {
            Book book = books.get(i);
            int bookNumtoAdd = book.getBooknum();
            bookNumtoAdd -= 1;
            topten.add(bookNumtoAdd);
            
            
           // System.out.println("Book #" + book.getBooknum() + " Rating: " + book.getRating());
        }
        
        return topten;
    }
}

    

