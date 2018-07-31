/**
 *
 */
package com.internousdev.ecsite.util;

/**
 * @author internousdev
 *
 */
public class CommonUtility {

//未検査キャスト警告回避
	@SuppressWarnings("unchecked")
	public static <T>T autoCast(Object src){
		T castedObject=(T)src;
		return castedObject;
	}

		/**
		 * 16桁の乱数取得
		 * return 16桁の乱数
		 */
		public static String getRandomValue(){
			//結果の初期化
			String value="";
			//乱数の受け皿のdouble型
			double d;
			//乱数取得開始(16桁)
			for(int i=0;i<16;i++){
				//0～1未満までの乱数掛ける10
				d=Math.random()*10;
				//1～9までの乱数dをStringの最後尾に追加
				value=value+(int)d;
			}
			return value;
		}
}
