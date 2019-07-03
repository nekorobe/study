package jihanki;

import java.util.ArrayList;
import java.util.Random;

/*
 *  VenderMachine
 *  商品の管理、お金の受け取り、購入、おつりの戻し処理、あたりくじ抽選
 */

class Machine {
	private static int itemCount = 0;
	private final static int coinValue[] = { 500, 100, 50, 10 }; // コイン種別
	private static int coinStock[] = { 100, 200, 100, 200 }; // コインのストック量
	private int id;
	private String name;
	private int price;
	private int stock;
	private static final int hitPerLot = 10; // あたりくじの確立 何本に1本当たる割合か （10なら1/10）

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
	public void printData() {
		System.out.printf("%1d %4s  %d円 %n",this.getId(),this.getName(),this.getPrice());
	}

	// 購入処理
	public int buy(int money) {
		money = money - this.price;
		this.stock -= 1;
		System.out.println(this.name + "を購入しました");
		return money;
	}

	public void lucky() {
		this.stock -= 1;
		System.out.println(this.name + "を選びました");

	}

	// つり銭の枚数計算処理
	public static void getOtsuri(int money) {
		int otsuri;
		int coinCount[] = { 0, 0, 0, 0 };

		otsuri = money;

		for (int i = 0; i < coinValue.length; i++) {
			coinCount[i] = otsuri / coinValue[i];
			if (i > 1) {
				if (coinStock[i] < 0) {
					coinStock[i] = 0;
					coinCount[i + 1] += (0 - coinStock[i]) * 10;
				}
			}
			coinStock[i] -= coinCount[i];
			otsuri %= coinValue[i];
		}

		System.out.println("おつりは" + money + "円で、");
		for(int i = 0;i<coinValue.length;i++){
			String coinName = coinValue[i]+"円玉";
		System.out.printf("%5s：%-2d枚%n",coinName,coinCount[i]);
		}
		System.out.println("のお返しです。ご利用ありがとうございました。");
		System.out.println("----------------------------");
		System.out.println("");
	}

	// 当たりくじ
	public static boolean lot() {
		boolean lucky;
		Random rnd = new Random();

		// 抽選部
		if (rnd.nextInt(hitPerLot) == 0) {
			lucky = true;
		} else {
			lucky = false;
		}

		// リスト作成
		ArrayList<String> head = new ArrayList<String>();
		ArrayList<String> foot = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			head.add("" + i + i + i);
			foot.add("" + i);
		}
		int lotNom = rnd.nextInt(head.size());

		System.out.println("当たりが出たらもう一本！");

		// 当落に応じた処理
		if (lucky) {
			System.out.println(head.get(lotNom) + foot.get(lotNom));
			System.out.println("大当たり！もう一本選んでネ！");
			System.out.println("");
			return true;
		} else {
			foot.remove(lotNom);
			System.out.println(head.get(lotNom) + foot.get(rnd.nextInt(foot.size())));
			System.out.println("残念、ハズレです。また買ってね！");
			System.out.println("");
			return false;
		}
	}

	// つり銭切れ表示（現在未使用）
	public void otsuriEmpty() {
		System.out.println("つり銭切れ：");
		for (int i = 1; i < coinValue.length - 1; i++) {
			if (coinStock[i] <= (coinStock[i] / coinStock[i + 1])) {
				System.out.println(coinValue[i] + "円玉");
			}
		}
	}

}
