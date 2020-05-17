package Entity;

public class Account {
	private String Account_ID;
	private String Password;
	private String Name;
	private String[] Job;
	private String Adress;
	private int Phone_Number;
	private String Email;

	public Account(String account_ID, String password,String name,String[] job, String adress, int phone_Number, String email) {
		Account_ID = account_ID;
		Password = password;
		Name = name;
		Job = job;
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
	
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	public String[] getJob() {
		return Job;
	}

	public void setAccount_ID(String[] job) {
		Job = job;
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
