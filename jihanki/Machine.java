package jihanki;

import java.util.Random;

/*
 *  VenderMachine
 *  商品の管理、お金の受け取り、購入、おつりの戻し処理、あたりくじ抽選
 */

class Machine {
	private static int itemCount = 0;
	private int id;
	private String name;
	private int price;
	private int stock;
	// private static ArrayList<String> itemList = new ArrayList<String>();

	// コンストラクタ
	Machine(String name, int price, int stock) {
		itemCount++;
		this.id = itemCount;
		this.name = name;
		this.price = price;
		this.stock = stock;
		// itemList.add(this.name);
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

	/*
	 * public static String getItemList(int id) { return itemList.get(id); }
	 */

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
		int count500;
		int count100;
		int count50;
		int count10;

		otsuri = money;

		count500 = otsuri / 500;
		otsuri %= 500;
		count100 = otsuri / 100;
		otsuri %= 100;
		count50 = otsuri / 50;
		otsuri %= 50;
		count10 = otsuri / 10;
		otsuri %= 10;

		System.out.println(money + "円のお返しで、");
		System.out.println("500円玉：" + count500 + "枚");
		System.out.println("100円玉：" + count100 + "枚");
		System.out.println("50円玉　：" + count50 + "枚");
		System.out.println("10円玉　：" + count10 + "枚");
		System.out.println("です。ご利用ありがとうございました。");
		System.exit(0);
	}

	// 当たりくじ
	public static boolean lots() {

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

}
