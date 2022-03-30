package notes6;

public class Card {

	private String person;
	private String planet;
	private int rank;
	
	public Card(String person, String planet, int rank) {
		this.person = person;
		this.planet = planet;
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public String getPerson() {
		return person;
	}

	public String getPlanet() {
		return planet;
	}
}
