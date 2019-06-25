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
		// ドリンクリストの作成 ※追加した際、switch文も変える必要があるため改善案を模索中
		// Machine drink[n] = new Machine("商品名", "価格", "在庫数");
	
		Machine drink1 = new Machine("コーヒー", 100, 10);
		Machine drink2 = new Machine("お茶", 120, 10);
		Machine drink3 = new Machine("ジュース", 150, 10);
		//Machine[3] = new Machine[];
		//
		
		System.out.println("いらっしゃいませ");
		System.out.println("こちらのお飲み物からお選びいただけます");
		
		// 商品の一覧表示（美しくないので自動生成できるようにしたい）
/*		for(int i = 0; i > Machine.getItemCount(); i++){
			System.out.println(Machine.getItemList(i).printData());
		}*/
		System.out.println(drink1.printData());
		System.out.println(drink2.printData());
		System.out.println(drink3.printData());
		
		// お金を入れる
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


		// 商品選択（ここも自動生成できそう）
		System.out.println("商品番号を選んでください");
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
		//　当たりくじの処理を入れたい

	}
}
