package gacha;

import java.util.ArrayList;

public class List {

	ArrayList<String> ssrList = new ArrayList<String>();
	ArrayList<String> srList = new ArrayList<String>();
	ArrayList<String> rList = new ArrayList<String>();
	ArrayList<String> boxList = new ArrayList<String>();

	List() { // 動作テスト用で手打ちのためfor文に修正予定　ListではなくMap型を試してもいいかも（ID:名前）
		// SSRリスト
		ssrList.add("5000");
		ssrList.add("5001");
		ssrList.add("5002");

		// SRリスト
		srList.add("4000");
		srList.add("4001");
		srList.add("4002");
		srList.add("4003");
		srList.add("4004");

		// Rリスト
		rList.add("3000");
		rList.add("3001");
		rList.add("3002");
		rList.add("3003");
		rList.add("3004");
		rList.add("3005");
		rList.add("3006");
		rList.add("3007");
		rList.add("3008");
		rList.add("3009");

		// BOXリスト
		boxList.add("5000 SSR!!");
		boxList.add("5001 SSR!!");
		boxList.add("5002 SSR!!");

		boxList.add("4000 SR!");
		boxList.add("4001 SR!");
		boxList.add("4002 SR!");
		boxList.add("4003 SR!");
		boxList.add("4004 SR!");
		boxList.add("4005 SR!");
		boxList.add("4006 SR!");
		
		boxList.add("3000");
		boxList.add("3001");
		boxList.add("3002");
		boxList.add("3003");
		boxList.add("3004");
		boxList.add("3005");
		boxList.add("3006");
		boxList.add("3007");
		boxList.add("3008");
		boxList.add("3009");
		boxList.add("3010");
		boxList.add("3011");
		boxList.add("3012");
		boxList.add("3013");
		boxList.add("3014");
		boxList.add("3015");
		boxList.add("3016");
		boxList.add("3017");
		boxList.add("3018");
		boxList.add("3019");
		boxList.add("3020");
		boxList.add("3021");
		boxList.add("3022");
		boxList.add("3023");
		boxList.add("3024");
		boxList.add("3025");
		boxList.add("3026");
		boxList.add("3027");
		boxList.add("3028");
		boxList.add("3029");
		boxList.add("3030");
		boxList.add("3031");
		boxList.add("3032");
		boxList.add("3033");
		boxList.add("3034");
		boxList.add("3035");
		boxList.add("3036");
		boxList.add("3037");
		boxList.add("3038");
		boxList.add("3039");
		boxList.add("3040");
		boxList.add("3041");
		boxList.add("3042");
		boxList.add("3043");
		boxList.add("3044");
		boxList.add("3045");
		boxList.add("3046");
		boxList.add("3047");
		boxList.add("3048");
		boxList.add("3049");
		boxList.add("3050");
		boxList.add("3051");
		boxList.add("3052");
		boxList.add("3053");
		boxList.add("3054");
		boxList.add("3055");
		boxList.add("3056");
		boxList.add("3057");
		boxList.add("3058");
		boxList.add("3059");
		boxList.add("3060");
		boxList.add("3061");
		boxList.add("3062");
		boxList.add("3063");
		boxList.add("3064");
		boxList.add("3065");
		boxList.add("3066");
		boxList.add("3067");
		boxList.add("3068");
		boxList.add("3069");
		boxList.add("3070");
		boxList.add("3071");
		boxList.add("3072");
		boxList.add("3073");
		boxList.add("3074");
		boxList.add("3075");
		boxList.add("3076");
		boxList.add("3077");
		boxList.add("3078");
		boxList.add("3079");
		boxList.add("3080");
		boxList.add("3081");
		boxList.add("3082");
		boxList.add("3083");
		boxList.add("3084");
		boxList.add("3085");
		boxList.add("3086");
		boxList.add("3087");
		boxList.add("3088");
		boxList.add("3089");
		boxList.add("3090");
		boxList.add("3091");
		boxList.add("3092");
		boxList.add("3093");
		boxList.add("3094");
		boxList.add("3095");
		boxList.add("3096");
		boxList.add("3097");
		boxList.add("3098");
		boxList.add("3099");
	}

	public String getSSR(int ssrId) {
		String result = ssrList.get(ssrId);
		return result;
	}

	public int getLengthSSR() {
		return ssrList.size();
	}

	public String getSR(int srId) {
		String result = srList.get(srId);
		return result;
	}

	public int getLengthSR() {
		return srList.size();
	}

	public String getR(int rId) {
		String result = rList.get(rId);
		return result;
	}

	public int getLengthR() {
		return rList.size();
	}

	public String getBOX(int boxId) {
		String result = boxList.get(boxId);
		boxList.remove(boxId);
		return result;
	}

	public int getLengthBOX() {
		return boxList.size();
	}

}
