package Keeptrack;

import Entity.Account;

public class CurrentAccount {
	private static Account currentAccount = null;

	private CurrentAccount(Account account) {
		this.currentAccount = account;
	}

	public static Account setCurrentAccount(String Account_ID, String Name, String[] jobs, String Address,
			int Phone_Number, String Email) {
		if (currentAccount == null) {
			currentAccount = new Account(Account_ID, null, Name, jobs, Address, Phone_Number, Email);
		}
		return currentAccount;
	}

	public static Account setCurrentAccount(Account account) {
		if (currentAccount == null) {
			currentAccount = account;
		}
		return currentAccount;
	}

	public static Account getCurrentAccount() {
		return currentAccount;
	}

	public static void resetAcccount() {
		currentAccount = null;
	}

	public static boolean checkJob(String job) {
		for (String temp : currentAccount.getJob()) {
			if (temp.equals(job)) {
				return true;
			}
		}
		return false;
	}

}
