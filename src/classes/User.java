package classes;

public class User {

	private String username;
	private Portfolio portfolio;
	
	public User() {
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public User setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
		return this;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", portfolio=" + portfolio + "]";
	}
	
	
}
