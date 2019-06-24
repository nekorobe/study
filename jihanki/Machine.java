package jihanki;

/*
 * VenderMachine
 * 
 */

class Machine {
	private static int itemCount = 0;
	private int id;
	private String name;
	private int price;
	private int stock;// ※現在未使用

	// コンストラクタ
	Machine(String name, int price, int stock) {
		itemCount ++;
		this.id = itemCount;
		this.name = name;
		this.price = price;
		this.stock = stock;
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

	// 購入処理
	public void buy(int money) {
		int count500;
		int count100;
		int count50;
		int count10;
		int otsuriSum;

		if ((this.stock > 0) && (money > this.price)) {
			money = money - this.price;
			otsuriSum = money;
			System.out.println(this.name + "を購入しました。");
			this.stock -= 1;

			// つり銭の枚数計算（ArrayListできれいにまとめられそう）
			count500 = money / 500;
			money %= 500;
			count100 = money / 100;
			money %= 100;
			count50 = money / 50;
			money %= 50;
			count10 = money / 10;
			money %= 10;

			System.out.println("おつりの合計は" + otsuriSum + "円で、");
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
