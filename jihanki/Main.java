package jihanki;

import java.util.Scanner;

/*
 * 自販機プログラム
 * @TODO 連続購入の実装、在庫管理、
 * @TODO 管理者モードの実装（在庫補充、商品追加など）
 * @TODO コインの枚数管理を行い、つり銭切れ機能の実装
 */

public class Main {

	public static void main(String[] args) {

		int money = 0;
		// ドリンクリストの作成
		Machine[] drinks = new Machine[3];
		drinks[0] = new Machine("コーヒー", 100, 10);
		drinks[1] = new Machine("お茶", 120, 10);
		drinks[2] = new Machine("ジュース", 150, 10);
		// drinks[n] = new Machine("商品名", "価格", "在庫数");


		System.out.println("いらっしゃいませ");
		System.out.println("こちらのお飲み物からお選びいただけます");

		// 商品の一覧表示
		for (int i = 0; i < Machine.getItemCount(); i++) {
			System.out.println(drinks[i].printData());
		}

		// お金を入れる
		money = insertCoin(money);

		// 商品選択
		choice(money, drinks);

		// 当たりくじの処理を入れたい

	}

	// お金を入れる
	public static int insertCoin(int money) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("いくらお金を入れますか？");
				String input = scan.next();
				money = Integer.parseInt(input);

				if (money % 10 == 0) {
					break;
				} else {
					System.out.println("※お金は10円単位で入れてください");
				}
			} catch (Exception e) {
				System.out.println("半角数字でない値が入力されています");
				System.out.println("再度、数字を入力してください");
			}
		}
		return money;
	}

	// 商品選択
	public static void choice(int money, Machine drinks[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("商品番号を選んでください");
		while (true) {
			int buttonNom = scan.nextInt();
			if (buttonNom < drinks.length) {
				drinks[buttonNom - 1].buy(money);
				System.exit(0);
			} else {
				System.out.println("※商品番号が間違っています。もう一度選んでください。");
			}
		}
	}
}
