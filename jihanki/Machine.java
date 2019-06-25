package jihanki;

import java.util.ArrayList;

/*
 *  VenderMachine
 *  商品の管理、お金の受け取り、購入、おつりの戻し処理
 */

class Machine {
	private static int itemCount = 0;
	private int id;
	private String name;
	private int price;
	private int stock;// ※現在未使用
	private static ArrayList<String> itemList = new ArrayList<String>();

	// コンストラクタ
	Machine(String name, int price, int stock) {
		itemCount++;
		this.id = itemCount;
		this.name = name;
		this.price = price;
		this.stock = stock;
		itemList.add(this.name);
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public static int getItemCount() {
		return itemCount;
	}
	
	public static String getItemList(int id) {
		return itemList.get(id);
	}

	// 商品情報取得
	public String printData() {
		return (this.getId() + " " + this.getName() + " " + this.getPrice() + "円");
	}

	// 購入処理
	public void buy(int money) {
		int count500;
		int count100;
		int count50;
		int count10;
		int otsuri;

		if ((this.stock > 0) && (money > this.price)) {
			money = money - this.price;
			otsuri = money;
			System.out.println(this.name + "を購入しました。");
			this.stock -= 1;

			// つり銭の枚数計算
			count500 = otsuri / 500;
			otsuri %= 500;
			count100 = otsuri / 100;
			otsuri %= 100;
			count50 = otsuri / 50;
			otsuri %= 50;
			count10 = otsuri / 10;
			otsuri %= 10;

			System.out.println("おつりの合計は" + money + "円で、");
			System.out.println("500円玉：" + count500 + "枚");
			System.out.println("100円玉：" + count100 + "枚");
			System.out.println("50円玉　：" + count50 + "枚");
			System.out.println("10円玉　：" + count10 + "枚");
			System.out.println("です。ご利用ありがとうございました。");

		} else if (stock <= 0) {
			System.out.println("申し訳ありません、現在品切れです。"); // ※現在未使用（連続購入が出来るようになったら在庫管理を実装予定）

		} else {
			System.out.println("金額が足りませんでした。" + money + "円を返却します。");
		}
	}
}
