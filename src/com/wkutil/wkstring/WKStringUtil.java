package com.wkutil.wkstring;
/**
 *
 * @version 2017年6月2日 下午2:33:25
 */
public class WKStringUtil {
	
	private static final String EMPTY_STRING = "";
	
	/**
	 * 是否值为null
	 * @param value
	 * @return
	 */
	public static boolean isNull(String value){
		return null==value;
	}
	
	/**
	 * 是否是空值 <code>null</code> or <code>""</code> 都视为空值
	 * @param value 待检测的字符串
	 * @return true空字符串
	 */
	public static boolean isEmpty(String value){
		return isNull(value)||value.length()==0;
	}
	
	/**
	 * 如果字符串是<code>null</code>则返回<code>""</code>
	 * 否则返回本身
	 * @param str 待检测字符串
	 * @return
	 */
	public static String ifNull(String str){
		return ifNull(str, EMPTY_STRING);
	}
	
	/**
	 * 如果字符串是<code>null</code>则返回<code>toStr</code>
	 * 否则返回本身
	 * @param str 待检测字符串
	 * @param toStr 如果  null==str 替换 str
	 * @return
	 */
	public static String ifNull(String str,String toStr){
		return null==str?toStr:str;
	}
	

	/**
	 * 将String数组拼接成一个字符串
	 * @param args 要拼接的字符串数组
	 * @return
	 */
	public static String join(String... args){
		String str = null;
		if(null!=args&&args.length>0){
			StringBuilder sb = new StringBuilder();
			for (String string : args) {
				sb.append(string);
			}
			str = sb.toString();
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		System.out.println(isNull(null));
		System.out.println(isEmpty("asd"));
	}
	
	
}
