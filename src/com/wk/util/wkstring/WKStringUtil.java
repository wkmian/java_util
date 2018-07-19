package com.wk.util.wkstring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.wk.util.wkmonitoring.WKStopWatch;

/**
 * 关于String的工具类
 * @version 2017年6月2日 下午2:33:25
 */
public class WKStringUtil {
    
    /**
     * 禁止实例化
     */
    private WKStringUtil(){}
	
    private static final String EMPTY_STRING = "";
    
    /**
     * 利用uuid产生一个随机32位字符串（不包含中划线-）
     * @return
     */
    public static final String getToken(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
	
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
     * 判断两个String是否相等，会处理null的情况<br />
     * 大小写敏感
     * <pre>
     *  WKStringutil.equals(null,null) = true;
     *  WKStringutil.equals(null,"aa") = false;
     * </pre>
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equals(String str1,String str2){
        return equals(str1, str2,false);
    }
    
    /**
     * 判断两个String是否相等，会处理null的情况<br />
     * 大小写不敏感
     * <pre>
     *  WKStringutil.equals(null,null) = true;
     *  WKStringutil.equals(null,"aa") = false;
     * </pre>
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equalsIgnoreCase(String str1,String str2){
        return equals(str1, str2,true);
    }
    
    /**
     * 判断两个String是否相等
     * @param str1
     * @param str2
     * @param isIgnoreCase  true 忽略大小写
     * @return
     */
    private static boolean equals(String str1,String str2,boolean isIgnoreCase){
        if(null==str1){
            return null==str2;
        }
        return isIgnoreCase?str1.equalsIgnoreCase(str2):str1.equals(str2);
    }
    
    
    /**
     * 将一个字符串的首字母大写 <br />
     * 
     * <ul>
     	<li>WKStringUtil.FirstCharToUpperCase("abc") = "Abc"</li>
     	<li>WKStringUtil.FirstCharToUpperCase(null) = null</li>
     </ul>
     * 
     * 
     * @param str
     * @return
     */
    public static String FirstCharToUpperCase(String str){
        if(isEmpty(str)){
            return str;
        }
        return new StringBuilder(str.length())
        .append(Character.toTitleCase(str.charAt(0)))
        .append(str.substring(1))
        .toString();
    }
    
    /**
     * 将一个字符串的首字母大写 <br />
     * 
     * <ul>
     	<li>WKStringUtil.FirstCharToUpperCase("ABC") = "Abc"</li>
     	<li>WKStringUtil.FirstCharToUpperCase(null) = null</li>
     </ul>
     * 
     * 
     * @param str
     * @return
     */
    public static String FirstCharToLowerCase(String str){
        if(isEmpty(str)){
            return str;
        }
        return new StringBuilder(str.length())
        .append(Character.toLowerCase(str.charAt(0)))
        .append(str.substring(1))
        .toString();
    }
    
    /**
     * 将String[] 连接成一个字符串
     * <ul>
     	<li>WKStringUtil.join( "," , ["a","b","c"] ) = "a,b,c"</li>
     	<li>WKStringUtil.join( "," , [null,"b","c"] ) = ",b,c"</li>
     	<li>WKStringUtil.join( "," , [] ) = ""</li>
     	<li>WKStringUtil.join( "," , null ) = null</li>
     </ul>
     * @param separator
     * @param array
     * @return
     */
    public static String join(String separator,Object[] array){
        if(null==array){
            return null;
        }
        int arraySize = array.length;
        int bufSize = arraySize==0?0:
            (array[0] == null?16:array[0].toString().length()) * arraySize;
        StringBuilder buf = new StringBuilder(bufSize);
        for (int i = 0; i <arraySize; i++) {
            if(i>0){
                buf.append(separator);
            }
            if(array[i]!=null){
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }
    
    /**
     * 将String[] 连接成一个字符串
     * <ul>
        <li>WKStringUtil.join( ["a","b","c"] ) = "abc"</li>
        <li>WKStringUtil.join( [null,"b","c"] ) = "bc"</li>
        <li>WKStringUtil.join( [] ) = ""</li>
        <li>WKStringUtil.join( null ) = null</li>
     </ul>
     * @param separator
     * @param array
     * @return
     * @author dwk
     * 2017年6月9日 上午11:58:07
     */
    public static String join(Object[] array){
        return join("",array);
    }
    
    /**
     * 将String[] 连接成一个字符串
     * <ul>
        <li>WKStringUtil.join( ["a","b","c"] ) = "abc"</li>
        <li>WKStringUtil.join( [null,"b","c"] ) = "bc"</li>
        <li>WKStringUtil.join( [] ) = ""</li>
        <li>WKStringUtil.join( null ) = null</li>
     </ul>
     * @param separator
     * @param array
     * @return
     * @author dwk
     * 2017年6月9日 上午11:58:07
     */
    public static String join(String... array){
        return join(EMPTY_STRING,array);
    }
    
    
    /**
     * 将String[] 连接成一个字符串
     * <ul>
     	<li>WKStringUtil.join( "," , ["a","b","c"] ) = "a,b,c"</li>
     	<li>WKStringUtil.join( "," , [null,"b","c"] ) = ",b,c"</li>
     	<li>WKStringUtil.join( "," , [] ) = ""</li>
     	<li>WKStringUtil.join( "," , null ) = null</li>
     </ul>
     * @param separator
     * @param array
     * @return
     */
    public static String join(String separator,Iterator iterator){
        if(null==iterator){
            return null;
        }
        StringBuilder buf = new StringBuilder(256);
        Object obj = null;
        while(iterator.hasNext()){
            obj = iterator.next();
            if(null!=obj){
                buf.append(obj);
            }
            if(iterator.hasNext()){
                buf.append(separator);
            }
        }
        return buf.toString();
    }
    
    /**
     * 将String[] 连接成一个字符串
     * <ul>
     	<li>WKStringUtil.join( "," , ["a","b","c"] ) = "a,b,c"</li>
     	<li>WKStringUtil.join( "," , [null,"b","c"] ) = ",b,c"</li>
     	<li>WKStringUtil.join( "," , [] ) = ""</li>
     	<li>WKStringUtil.join( "," , null ) = null</li>
     </ul>
     * @param separator
     * @param array
     * @return
     */
    public static String join(Iterator iterator){
        return join(EMPTY_STRING, iterator);
    }
    
    
    /**
     * 清除首尾字符串
     * @param str 
     * @param trimChars 
     *              要在首尾去除的字符<br />   
     *              1.完全匹配<br /> 
     *              2.null或者空值 则不处理
     * @return
     */
    public static String trim(String str,String trimChars){
        return trim(str, trimChars, 0);
    }
    
    /**
     * 清除首字符串
     * @param str 
     * @param trimChars 
     *              要在首尾去除的字符<br />   
     *              1.完全匹配<br /> 
     *              2.null或者空值 则不处理
     * @return
     */
    public static String trimStart(String str,String trimChars){
        return trim(str, trimChars, -1);
    }
    
    /**
     * 清除尾字符串
     * @param str 
     * @param trimChars 
     *              要在首尾去除的字符<br />   
     *              1.完全匹配<br /> 
     *              2.null或者空值 则不处理
     * @return
     */
    public static String trimEnd(String str,String trimChars){
        return trim(str, trimChars, 1);
    }
    
    /**
     * 清除首尾字符串
     * @param str 
     * @param trimChars 
     *              要在首尾去除的字符<br />   
     *              1.完全匹配<br /> 
     *              2.null或者空值 则不处理
     * @param mode -1 仅去除首   0 全部       1 仅去除尾
     * @return
     */
    private static String trim(String str,String trimChars,int mode){
        if(null==str){
            return null;
        }
        if(null==trimChars){
            return str;
        }
        
        StringBuffer sb = new StringBuffer(str);
        
        if(mode<=0){
            //
            while ((sb.indexOf(trimChars))==0) {
                sb.delete(0, trimChars.length());
            }
        }
        
        if(mode>=0){
            //
            while ((sb.lastIndexOf(trimChars))==sb.length()-1) {
                sb.delete(sb.length()-trimChars.length(), sb.length());
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String a = "ddddeeeeeeeeeeeeeeessssdssssssd";
        String b = "d";
        
       WKStopWatch stopWatch = new WKStopWatch("trim 测试");
       stopWatch.start("trim");       
        
        for (int i = 0; i < 100000; i++) {
            trim(a,b);
        }
        
        stopWatch.stop();
        stopWatch.printInfo();
        
    }
    
}
