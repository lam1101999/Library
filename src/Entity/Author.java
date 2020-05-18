package Entity;

public class Author {
	private String Author_ID;
	private String Name;

	public Author(String Author_ID, String Name) {
		this.Author_ID = Author_ID;
		this.Name = Name;
	}

	public String getAuthor_ID() {
		return Author_ID;
	}

	public void setAuthor_ID(String Author_ID) {
		this.Author_ID = Author_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String toString() {
		return Name;
	}
}
