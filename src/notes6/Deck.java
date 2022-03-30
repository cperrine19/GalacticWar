package notes6;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class Deck extends LinkedList<Card> {
	List<String> people = List.of("Bobba Fett", "Anakin Skywalker", "Luke Skywalker", "Leia Organa", "Han Solo", "Padmé Amidala",
		      "Jabba the Hutt", "Chewbacca", "Yoda", "C3-PO", "R2-D2", "Shmi Skywalker",
		      "Rey Skywalker", "Jar-Jar Binks", "Maz Kanata", "Wedge Antilles");
	List<String> planets = List.of("Tatooine", "Alderean", "Hoth", "Kamino", "Naboo", "Dagobah");

	public Deck() {
		for(int personPos = 0; personPos < people.size(); personPos++) {
			int rank = personPos + 1;
			String person = people.get(personPos);
			
			for(String planet : planets) {
				add(new Card(person, planet, rank));
				
			}
		}
	}
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("List of Cards:\n");
		for(Card card : this) {
			b.append("  ").append(card).append(System.lineSeparator());
		}
		return b.toString();
	}
	public void shuffle() {
		Collections.shuffle(this);
			
		}
		public Card draw() {
			return remove(0);
			
	}
		
		}

