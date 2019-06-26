package jihanki;

import java.util.Random;

public class Lots {

	public static void main(String[] args) {
	}
	public static void lots(){
		
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
}
