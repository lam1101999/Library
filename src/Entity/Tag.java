package Entity;

public class Tag {
	private String Tag_ID;
	private String Name;

	public Tag(String Tag_ID, String Name) {
		this.Tag_ID = Tag_ID;
		this.Name = Name;
	}

	public String getTag_ID() {
		return Tag_ID;
	}

	public void setID_Name(String Tag_ID) {
		this.Tag_ID = Tag_ID;
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
