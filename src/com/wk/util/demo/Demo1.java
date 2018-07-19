package com.wk.util.demo;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dwk
 * @version 2017年7月20日 上午10:43:38
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {  
        //通过反射获取到方法  
        Method declaredMethod = Demo1.class.getDeclaredMethod("findStr", int.class,Map.class);  
        //获取到方法的参数列表  
        Type[] parameterTypes = declaredMethod.getGenericParameterTypes();  
        for (Type type : parameterTypes) {  
            System.out.println(type);  
            //只有带泛型的参数才是这种Type，所以得判断一下  
            if(type instanceof ParameterizedType){  
                ParameterizedType parameterizedType = (ParameterizedType) type;  
                //获取参数的类型  
                System.out.println(parameterizedType.getRawType());  
                //获取参数的泛型列表  
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();  
                for (Type type2 : actualTypeArguments) {  
                    System.out.println(type2);  
                }  
            }  
        }  
    }  
      
    public static List<String> findStr(int id,Map<Integer, String> map){  
        return null;  
    }  
}
