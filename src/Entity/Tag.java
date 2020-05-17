package Entity;

public class Tag {
	private String ID_Name;
	private String Name;

	public Tag(String ID_Name, String Name) {
		this.ID_Name = ID_Name;
		this.ID_Name = Name;
	}

	public String getID_Name() {
		return ID_Name;
	}

	public void setID_Name(String iD_Name) {
		ID_Name = iD_Name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
