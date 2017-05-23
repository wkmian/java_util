package com.wkmianutil.wkboolean;
/**
 *
 * @author dwk
 * @version 2017年5月23日 下午4:23:38
 */
public class WKBoolean {
	public static final int TRUE = 1;
	public static final int FALSE = 0;
	
	/**
	 * 转换成WKBoolean
	 * @param value
	 * @return
	 * @author dwk
	 * 2017年5月23日 下午5:00:26
	 */
	public static int convert2WKBoolean(boolean value){
		return value?TRUE:FALSE;
	}
	
	/**
	 * 获取 非 值
	 * @param value
	 * @return
	 * @author dwk
	 * 2017年5月23日 下午5:00:44
	 */
	public static int getNotWKBoolean(int value){
		return convert2WKBoolean(1==value);
		
	}
	
}
