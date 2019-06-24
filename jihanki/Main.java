package jihanki;

import java.util.Scanner;

/*
 * 自販機プログラム
 * @TODO 連続購入の実装、在庫管理、リスト形式を使用した方がスマートかどうかの検討
 * @TODO 管理者モードの実装（在庫補充、商品追加など）
 * @TODO コインの枚数管理を行い、つり銭切れ機能の実装
 */

public class Main {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int money = 0;
		// ドリンクリストの作成 ※追加した際、switch文も変える必要あり　改善案を模索中
		Machine drink1 = new Machine("コーヒー", 100, 10);
		Machine drink2 = new Machine("お茶", 120, 10);
		Machine drink3 = new Machine("ジュース", 150, 10);

		// お金を入れる
		while (true) {
			try {
				System.out.println("お金を入れてください");
				String input = scan.next(); // val1に数字入力の受付
				money = Integer.parseInt(input);

				if (money % 10 == 0) {
					break;
				} else {
					System.out.println("※お金は10円単位で入れてください");
				}
			} catch (Exception e) { // 数値以外の入力をはじく
				System.out.println("半角数字でない値が入力されています");
				System.out.println("再度、数字を入力してください");
			}
		}

		System.out.println("商品番号を選んでください");
		// 商品の一覧表示（美しくないので自動生成できるように改善したい）
		System.out.println(drink1.getId() + " " + drink1.getName() + " " + drink1.getPrice() + "円");
		System.out.println(drink2.getId() + " " + drink2.getName() + " " + drink2.getPrice() + "円");
		System.out.println(drink3.getId() + " " + drink3.getName() + " " + drink3.getPrice() + "円");

		// 商品選択（ここも自動生成できそう）
		while (true) {
			int buttonNom = scan.nextInt();

			switch (buttonNom) {
			case 1:
				drink1.buy(money);
				System.exit(0);
			case 2:
				drink2.buy(money);
				System.exit(0);
			case 3:
				drink3.buy(money);
				System.exit(0);
			default:
				System.out.println("※商品番号が間違っています。もう一度選んでください。");
			}
		}
	}
}
