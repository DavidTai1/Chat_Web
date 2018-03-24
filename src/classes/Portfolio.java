package classes;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
	private Broker broker;
	private List<Stock> stocks;

	public Broker getBroker() {
		return broker;
	}

	public Portfolio setBroker(Broker broker) {
		this.broker = broker;
		return this;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public Portfolio setStocks(List<Stock> stocks) {
		this.stocks = stocks;
		return this;
	}
	
	public void addStock(Stock stock){
		if(this.stocks == null)
			stocks=new ArrayList<>();
		stocks.add(stock);
	}

	@Override
	public String toString() {
		return "Portfolio [broker=" + broker + ", stocks=" + stocks + "]";
	}

}
