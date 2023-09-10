
public class Book {
	private int booknum;
	private int bookid;
	private String isbn;
	private int isbn13;
	private String author;
	private int year;
	private String title;
	private String language;
	private double rating;
	private int totalRating;
	private String imgurl;
   

Book(int booknum, int tranbookid, String tranisbn, String tranauthor, int tranyear, String trantitle, String tranlang, double tranrating, int trantotalrating, String tranimg) {
this.booknum = booknum;
this.bookid = tranbookid;
this.isbn = tranisbn;	
this.author = tranauthor;
this.year = tranyear;
this.title = trantitle;
this.language = tranlang;
this.rating = tranrating;
this.totalRating = trantotalrating;
this.imgurl = tranimg;

	
	
}


public int getBooknum() {
	return booknum;
}


public int getBookid() {
	return bookid;
}


public String getIsbn() {
	return isbn;
}


public int getIsbn13() {
	return isbn13;
}


public String getAuthor() {
	return author;
}


public int getYear() {
	return year;
}


public String getTitle() {
	return title;
}


public String getLanguage() {
	return language;
}


public double getRating() {
	return rating;
}


public int getTotalRating() {
	return totalRating;
}


public String getImgurl() {
	return imgurl;
}
}
