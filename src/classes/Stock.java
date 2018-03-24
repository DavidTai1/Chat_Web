package classes;

public class Stock {
	private String companyName;
	private String symbol;

	public String getCompanyName() {
		return companyName;
	}

	public Stock setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public String getSymbol() {
		return symbol;
	}

	public Stock setSymbol(String symbol) {
		this.symbol = symbol;
		return this;
	}

	@Override
	public String toString() {
		return "Stock [companyName=" + companyName + ", symbol=" + symbol + "]";
	}
}
