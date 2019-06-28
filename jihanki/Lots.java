package jihanki;

import java.util.Random;

public class Lots {

	public static void main(String[] args) {
	}

	public static void lots() {

		Random rnd = new Random();
		String[] head = new String[10];
		String[] foot = new String[10];
		for (int i = 0; i < 10; i++) {
			head[i] = "" + i + i + i;
			foot[i] = "" + i;
		}
		String lots = head[rnd.nextInt(9)] + foot[rnd.nextInt(9)];
		System.out.println(lots);

		if (Integer.parseInt(lots) % 1111 == 0) {
			System.out.println("大当たり！もう一本選んでネ！");

		}
	}

	public static void getOtsuri(int money) {
		int otsuri;
		int count[] = { 0, 0, 0, 0 };// [0]=500,[1]=100,[2]=50,[3]=10
		int count500;
		int count100;
		int count50;
		int count10;

		int stock[] = { 10, 20, 10, 20 };
		int stock500 = 10;
		int stock100 = 20;
		int stock50 = 10;
		int stock10 = 20;

		otsuri = money;

		for (int i = 1; i < 3; i++) {
			count[i] = otsuri / 500;
			if (stock[i] < 0) {
				stock[i] = 0;
				count[i + 1] = +(0 - stock[i]) * 10;
			}
			stock[i] = -count[i];
			otsuri %= 500;
		}
		
		count500 = otsuri / 500;
		stock500 = -count500;
		otsuri %= 500;

		count100 = otsuri / 100;
		if (stock500 < 0) {
			stock500 = 0;
			count100 = +(0 - stock500) * 10;
		}
		stock100 = -count100;
		otsuri %= 100;

		count50 = otsuri / 50;
		if (stock100 < 0) {
			stock100 = 0;
			count50 = +(0 - stock100) * 10;
		}
		stock50 = -count50;
		otsuri %= 50;

		count10 = otsuri / 10;
		if (stock50 < 0) {
			stock50 = 0;
			count10 = +(0 - stock50) * 10;
		}
		stock10 = -count10;
		otsuri %= 10;

		System.out.println(money + "円のお返しで、");
		System.out.println("500円玉：" + count500 + "枚");
		System.out.println("100円玉：" + count100 + "枚");
		System.out.println("50円玉　：" + count50 + "枚");
		System.out.println("10円玉　：" + count10 + "枚");
		System.out.println("です。ご利用ありがとうございました。");
		System.out.println("----------------------------");
		System.out.println("");
	}
}
