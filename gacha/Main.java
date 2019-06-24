package gacha;

import java.util.Random;
import java.util.Scanner;

/*
 * @TODO　実装予定　：　ピックアップガチャ　List改善　BOXガチャの打ち止め処理　10連ボーナス（SR確定）　IDによるデータ紐付け
 */
public class Main {

	static List list = new List();
	static Random rnd = new Random();
	static Scanner scan = new Scanner(System.in);
	static double gacha;

	public static void main(String[] args) {

	// config---------------------------------------//
		// 確率設定
		final double ssrProb = 0.01;
		final double srProb = 0.1;

		// 引く回数
		final int n = 10;

		// ガチャ種別
		// 1：BOXガチャ 2:通常ガチャ
		final int gachaType = 2;
	// ---------------------------------------------//

		// メインシーケンス

		System.out.println("ガチャシミュレーター　開始するにはEnterを押してください");
		scan.nextLine();
		for (;;) {
			switch (gachaType) {
			case 1:
				boxGacha(n);
				break;
			case 2:
				nomalGacha(n, ssrProb, srProb);
				break;
			}
			continueGacha();

		}
	}

	public static void boxGacha(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(list.getBOX(rnd.nextInt(list.getLengthBOX())));
		}
		System.out.println("あと" + list.getLengthBOX() + "枚です");
	}

	public static void nomalGacha(int n, double ssrProb, double srProb) {
		for (int i = 0; i < n; i++) {
			gacha = rnd.nextDouble();
			if (gacha < ssrProb) {
				System.out.print("SSレア！" + list.getSSR(rnd.nextInt(list.getLengthSSR())) + " ");
			} else if (gacha < srProb) {
				System.out.print("Sレア！" + list.getSR(rnd.nextInt(list.getLengthSR())) + " ");
			} else {
				System.out.print("レア！" + list.getR(rnd.nextInt(list.getLengthR())) + " ");
			}
			System.out.println(gacha);
		}
	}

	public static void continueGacha() {

		for (;;) {
			System.out.println("続けて引きますか");
			System.out.println("1:はい　2：いいえ");
			int choice = scan.nextInt();

			if (choice == 1) {
				break;
			} else if (choice == 2) {
				System.exit(0);
			} else {
				System.out.println("※1か2で入力してください");
			}
		}
	}

}
