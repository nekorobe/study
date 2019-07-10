package Trump;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
	static ArrayList<Integer> nom = new ArrayList<Integer>();
	static ArrayList<String> suite = new ArrayList<String>();
	static ArrayList<Integer> nomDealer = new ArrayList<Integer>();
	static ArrayList<String> suiteDealer = new ArrayList<String>();
	static int handCount = 0;
	static int handSum = 0;
	static int dealerSum = 0;

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Cards BlackJack = new Cards();

		Cards.shuffle();
		draw(nomDealer, suiteDealer, 1);

		draw(nom, suite, 2);
		handCount = +2;

		draw(nomDealer, suiteDealer, 1);
		// int nom = Cards.getNomber(Cards.Cards.get(0));
		// String suite = Cards.getSuite(Cards.Cards.get(0));
		System.out.print("ディーラーのカードは ");
		System.out.print(suiteDealer.get(0) + nomDealer.get(0) + ",「？」");
		System.out.println(" です");
		// dealerSum += Math.min(nomDealer.get(0), 10);

		System.out.print("あなたが引いたカードは ");
		for (int i = 0; i < handCount; i++) {
			System.out.print(suite.get(i) + nom.get(i) + ",");
		}
		System.out.println(" です");
		for (int i = 0; i < handCount; i++) {
			handSum += Math.min(nom.get(i), 10);
		}
		System.out.println("数字の合計は " + handSum + " です。");

		while (conte()) {

			// 選択肢で分岐

			draw(nom, suite, 1);
			handCount += 1;
			System.out.print("あなたが引いたカードは ");
			System.out.print(suite.get(handCount - 1) + nom.get(handCount - 1));
			System.out.println(" です");
			handSum += Math.min(nom.get(handCount - 1), 10);

			System.out.println("数字の合計は " + handSum + " です。");
			if (handSum > 21) {
				System.out.println("Bust... あなたの負けです");
				System.exit(0);

			}
		}
		// ショーダウン

		System.out.println("---ディーラーショーダウン---");
		System.out.print("ディーラーのカードは ");
		for (int i = 0; i < nomDealer.size(); i++) {
			System.out.print(suiteDealer.get(i) + nomDealer.get(i) + ",");
			dealerSum += Math.min(nomDealer.get(i), 10);
		}
		System.out.println(" で、");
		System.out.println("数字の合計は" + dealerSum + " です。");
		System.out.println("");

		while (dealerSum <= 17) {
			System.out.println("17以下なのでもう一枚引きます ");
			draw(nomDealer, suiteDealer, 1);
			System.out.print("ディーラーが引いたカードは ");
			System.out.print(suiteDealer.get(nomDealer.size() - 1) + nomDealer.get(nomDealer.size() - 1));
			System.out.println(" です");
			dealerSum += Math.min(nomDealer.get(nomDealer.size() - 1), 10);
			System.out.print("数字の合計は ");
			System.out.println(dealerSum + " です。");
			System.out.println("");
		}

		if (dealerSum > 21) {
			System.out.println("ディーラーBust... あなたの勝ちです！");
			System.exit(0);

		}
		System.out.println("いざ勝負！ ");
		System.out.println("----------------------");
		System.out.println("ディーラーの数字は " + dealerSum);
		System.out.println("あなたの数字は " + handSum);
		System.out.println("----------------------");

		if (handSum > dealerSum) {
			System.out.println("あなたの勝ちです！");
		} else if (handSum < dealerSum) {
			System.out.println("あなたの負けです...");
		} else {
			System.out.println("引き分けです");
		}

	}

	public static void draw(ArrayList<Integer> whoNom, ArrayList<String> whoSuite, int n) {
		int drowNum = Math.min(n, Cards.Cards.size());
		for (int i = 0; i < drowNum; i++) {
			whoNom.add(Cards.getNomber(Cards.Cards.get(0)));
			whoSuite.add(Cards.getSuite(Cards.Cards.get(0)));
			// handCount++;
			Cards.Cards.remove(0);
		}
	}

	public static boolean conte() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("ヒット　オア　スタンド？");
			System.out.println("1：ヒット　2：スタンド");
			int select = scan.nextInt();

			if (select == 1) {
				return true;
			} else if (select == 2) {
				return false;
			} else {
				System.out.println("※1か2で入力してください");
			}
		}
	}
}
