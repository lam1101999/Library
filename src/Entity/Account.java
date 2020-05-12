package Entity;

public class Account {
	private String Account_ID;
	private String Name;
	private String Adress;
	private int Phone_Number;
	private String Email;

	public Account(String account_ID, String name, String adress, int phone_Number, String email) {
		Account_ID = account_ID;
		Name = name;
		Adress = adress;
		Phone_Number = phone_Number;
		Email = email;
	}

	public String getAccount_ID() {
		return Account_ID;
	}

	public void setAccount_ID(String account_ID) {
		Account_ID = account_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public int getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(int phone_Number) {
		Phone_Number = phone_Number;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
