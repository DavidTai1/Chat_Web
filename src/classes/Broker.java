package classes;

public class Broker {
	private String name;

	public String getName() {
		return name;
	}

	public Broker setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return "Broker [name=" + name + "]";
	}

}
