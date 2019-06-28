package jihanki;

import java.util.Random;

/*
 *  VenderMachine
 *  商品の管理、お金の受け取り、購入、おつりの戻し処理、あたりくじ抽選
 */

class Machine {
	private static int itemCount = 0;
	private static int coinValue[] = { 500, 100, 50, 10 };
	private static int coinStock[] = { 100, 200, 100, 200 };
	private int id;
	private String name;
	private int price;
	private int stock;

	// コンストラクタ
	Machine(String name, int price, int stock) {
		itemCount++;
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

	public static int getItemCount() {
		return itemCount;
	}

	public int getStock() {
		return this.stock;
	}

	// 商品情報取得
	public String printData() {
		return (this.getId() + " " + this.getName() + " " + this.getPrice() + "円");
	}

	// 購入処理
	public int buy(int money) {
		money = money - this.price;
		this.stock -= 1;
		System.out.println(this.name + "を購入しました");
		return money;
	}

	public void lucky() {
		if (this.stock > 0) {
			this.stock -= 1;
			System.out.println(this.name + "を選びました");
		} else {
			System.out.println("申し訳ありません、現在品切れです。");
		}
	}

	// つり銭の枚数計算処理
	public static void getOtsuri(int money) {
		int otsuri;
		int coinCount[] = { 0, 0, 0, 0 };

		otsuri = money;

		for (int i = 0; i < 4; i++) {
			coinCount[i] = otsuri / coinValue[i];
			if (i > 1) {
				if (coinStock[i] < 0) {
					coinStock[i] = 0;
					coinCount[i + 1] = +(0 - coinStock[i]) * 10;
				}
			}
			coinStock[i] = -coinCount[i];
			otsuri %= coinValue[i];
		}

		System.out.println(money + "円のお返しで、");
		System.out.println("500円玉：" + coinCount[0] + "枚");
		System.out.println("100円玉：" + coinCount[1] + "枚");
		System.out.println("50円玉　：" + coinCount[2] + "枚");
		System.out.println("10円玉　：" + coinCount[3] + "枚");
		System.out.println("です。ご利用ありがとうございました。");
		System.out.println("----------------------------");
		System.out.println("");
	}

	// 当たりくじ
	public static boolean lot() {

		Random rnd = new Random();
		String[] head = new String[10];
		String[] foot = new String[10];
		for (int i = 0; i < 10; i++) {
			head[i] = "" + i + i + i;
			foot[i] = "" + i;
		}

		System.out.println("当たりが出たらもう一本！");

		String lots = head[rnd.nextInt(9)] + foot[rnd.nextInt(9)];
		System.out.println(lots);

		if (Integer.parseInt(lots) % 1111 == 0) {
			System.out.println("大当たり！もう一本選んでネ！");
			System.out.println("");
			return true;
		} else {
			System.out.println("残念、ハズレです。また買ってね！");
			System.out.println("");
			return false;
		}
	}

	// つり銭切れ表示（現在未使用）
	public void tsuriGire() {
		System.out.println("つり銭切れ：");
		for (int i = 1; i < 3; i++) {
			if (coinStock[i] <= (coinStock[i] / coinStock[i + 1])) {
				System.out.println(coinValue[i] + "円玉");
			}
		}
	}

}
