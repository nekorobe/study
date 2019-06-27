package jihanki;

import java.util.Scanner;

/*
 * 自販機プログラム
 * @TODO 管理者モードの実装（在庫補充、商品追加など）
 * @TODO コードをループするようにする
 * @TODO コインの枚数管理を行い、つり銭切れ機能の実装
 * @TODO 最後に買った商品の一覧出力をする、まとめ買い機能
 */

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int money = 0;

		// ドリンクリストの作成
		Machine[] drinks = new Machine[3];
		drinks[0] = new Machine("コーヒー", 100, 10);
		drinks[1] = new Machine("お茶", 120, 10);
		drinks[2] = new Machine("ジュース", 150, 10);
		// drinks[n] = new Machine("商品名", "価格", "在庫数");

		/////////////////////////////////////////////////////////////

		// 商品の一覧表示

		System.out.println("いらっしゃいませ");
		System.out.println("こちらのお飲み物からお選びいただけます");

		printDrink(drinks);

		// お金を入れる
		money = insertCoin(money);

		while (true) {
			// 商品選択
			money = choice(money, drinks);

			// 金額が足りない場合自動で終了
			if (money < getMinPrice(drinks)) {
				Machine.getOtsuri(money);

			}
			// 続けて購入？
			conte(money);
		}
	}

	///////////////////////////////////////////////////////////////

	// 商品一覧表示
	public static void printDrink(Machine drinks[]) {
		for (int i = 0; i < Machine.getItemCount(); i++) {
			System.out.println(drinks[i].printData());
		}
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

	// 商品選択＆購入処理
	public static int choice(int money, Machine drinks[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("商品番号を入力してください");
		while (true) {
			int nom = scan.nextInt();
			if (nom <= drinks.length) {
				if ((drinks[nom - 1].getStock() > 0) && (money >= drinks[nom - 1].getPrice())) {
					money = drinks[nom - 1].buy(money);
					lots(drinks);
					break;
				} else if (drinks[nom - 1].getStock() <= 0) {
					System.out.println("申し訳ありません、現在品切れです。");
					break;
				} else {
					System.out.println("※金額が足りません。購入できませんでした。");
					break;
				}
			} else {
				System.out.println("※商品番号が間違っています。もう一度選んでください。");
			}
		}
		System.out.println("残りの金額は" + money + "円です");
		return money;
	}

	public static void conte(int money) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("続けて購入しますか？");
			System.out.println("1:はい　2：いいえ");
			int select = scan.nextInt();

			if (select == 1) {
				break;
			} else if (select == 2) {
				Machine.getOtsuri(money);
			} else {
				System.out.println("※1か2で入力してください");
			}
		}
	}

	// 商品の内最大の金額を返す
	public static int getMaxPrice(Machine drinks[]) {
		int max = 0;
		for (int i = 0; i < drinks.length; i++) {
			max = Math.max(max, drinks[i].getPrice());

		}
		return max;
	}

	// 商品の内最小の金額を返す
	public static int getMinPrice(Machine drinks[]) {

		int min = getMaxPrice(drinks);
		for (int i = 0; i < drinks.length; i++) {
			min = Math.min(min, drinks[i].getPrice());
		}
		return min;
	}

	// 当たりくじの処理
	public static void lots(Machine drinks[]) {
		Scanner scan = new Scanner(System.in);

		if (Machine.lots()) {
			System.out.println("（商品番号を入力してください）");
			while (true) {
				int nom = scan.nextInt();
				if (nom <= drinks.length) {
					if (drinks[nom - 1].getStock() > 0) {
						drinks[nom - 1].lucky();
						break;
					} else {
						System.out.println("※その商品は在庫切れです。別の商品を選んでください。");
					}
				} else {
					System.out.println("※商品番号が間違っています。もう一度選んでください。");
				}
			}
		}
	}
}
