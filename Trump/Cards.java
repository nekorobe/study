package Trump;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Cards {

	private final static String Suites[] = { "♠", "♥", "♦", "♣" };
	static ArrayList<Integer> Cards = new ArrayList<Integer>();
	static Random rnd = new Random();

/*	public static void main(String[] args) {

		shuffle();
		for (; Cards.size() > 0;) {
			System.out.println(getSuite(Cards.get(0)) + (getNomber(Cards.get(0))));
			Cards.remove(0);
		}
	}
*/
	Cards() {
		
	}

	public static String getSuite(int nom) {
		return Suites[((nom) % 4)];
	}

	public static int getNomber(int nom) {
		return (nom / 4) + 1;
	}

	public static void shuffle() {
		Cards.clear();
		for (int i = 0; i < 52; i++) {
			Cards.add(i);
		}
		Collections.shuffle(Cards);
	}

/*	public static void drow() {
		getSuite(Cards.get(0));
		getNomber(Cards.get(0));
		Cards.remove(0);
	}
	*/
}
