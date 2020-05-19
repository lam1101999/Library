package Entity;

public class Book {
	private String Book_ID;
	private String Name;
	private int Year;
	private String Author;
	private String Tag;

	public Book(String book_ID, String name, int year, String author, String tag) {
		Book_ID = book_ID;
		Name = name;
		Year = year;
		Author = author;
		Tag = tag;
	}

	public String getBook_ID() {
		return Book_ID;
	}

	public void setBook_ID(String book_ID) {
		Book_ID = book_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getTag() {
		return Tag;
	}

	public void setTag(String tag) {
		Tag = tag;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String toString() {
		return Name;
	}
}
