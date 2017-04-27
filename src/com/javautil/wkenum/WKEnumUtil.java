package com.javautil.wkenum;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dwk
 * @version 2017年3月27日 下午6:41:08
 */
public class WKEnumUtil {
	/**
	 * 根据枚举类型加载全部的枚举，循环比较WKEnumSuper实现枚举的getNumber()
	 * @param t 必须是实现 WKEnumSuper的枚举
	 * @param number
	 * @return
	 * @author dwk
	 * 2017年3月27日 下午6:46:06
	 */
	public static final <T extends Enum<T> > T getEnum( Class<T> t, int number){
		EnumSet<T> types = EnumSet.allOf(t);
		WKEnumSuper o = null;
		for (T type_tmp : types) {
			o = (WKEnumSuper) type_tmp;
			if(o.getNumber()==number){
				return type_tmp;
			}
		}
		return null;
	}
	
	/**
	 * 根据枚举类型加载全部的枚举，循环比较WKEnumSuper实现枚举的getNumber()
	 * 如果返回值为空，可自定义一个默认的返回值
	 * @param t 必须是实现 WKEnumSuper的枚举
	 * @param number
	 * @param defaultType
	 * @return
	 * @author dwk
	 * 2017年3月27日 下午6:46:56
	 */
	public static final <T extends Enum<T> > T getEnum( Class<T> t, int number,T defaultType){
		T t1 = getEnum(t, number);
		return null==t1?defaultType:t1;
	}
	
	public static final <T extends Enum<T> > boolean isExist( Class<T> t, int number){
		T type_tmp = getEnum(t, number);
		return null!=type_tmp;
	}
	
	/**
	 * 将enum转为list数组
	 * 可以将生成的数据提供给前端的下拉框使用
	 * @param t
	 * @param numberKey
	 * @param nameKey
	 * @return
	 */
	public static final List<Map<String,Object>> toList( Class t, String numberKey,String nameKey){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		EnumSet types = EnumSet.allOf(t);
		WKEnumSuper o = null;
		Map<String,Object> obj_map = null;
		for (Object type_tmp : types) {
			o = (WKEnumSuper) type_tmp;
			obj_map = new HashMap<String, Object>();
			obj_map.put(numberKey, o.getNumber());
			obj_map.put(nameKey, o.getName());
			list.add(obj_map);
		}
		return list;
	}
	
}
