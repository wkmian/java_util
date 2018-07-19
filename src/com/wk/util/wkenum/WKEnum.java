package com.wk.util.wkenum;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/**
 * 因为枚举的不能继承的特性，导致使用枚举作为状态类型并不方便（每次创建的时候都要写一些构造）。<br />
 * 本类模仿Enum的实现思路进行了改进，但是美中不足不能使用switch case判断。 <br />
 * 使用方法：1.子类需要继承本类并带入泛型。2.定义public static final 子类  = new 子类。3.子类可以定义属于自己的状态字段。<br />
 * 注意事项：1.本类提供查找指定number的子类，以及指定name的子类，所以要求number和name不可以重复。2.本类不像java.lang.Enum被switch case支持。3.好处是可以被继承
 * @author dwk
 * @version 2017年8月2日 上午10:21:02
 */
public class WKEnum<E extends WKEnum<E>> {
    private int number;
    private String name;
    
    /**
     * 获取 唯一number值
     */
    public int getNumber() {
        return number;
    }
    /**
     * 获取 唯一name值
     */
    public String getName() {
        return name;
    }
    
    public WKEnum(int number, String name) {
        this.number = number;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "WKEnum [number=" + number + ", name=" + name + "]";
    }
    /**
     * 查询WKEnum子类 <code>T</code> 中是否存在指定的number
     * @param t
     * @param number
     * @return
     * @author dwk
     * 2017年8月2日 下午1:20:29
     */
    public static <T extends WKEnum<T>> boolean  isExist(Class<T> t,int number){
        return null==getWKEnum(t, number);
    }
    
    /**
     * 查询WKEnum子类 <code>T</code> 中是否存在指定的name
     * @param t
     * @param name
     * @return
     * @author dwk
     * 2017年8月2日 下午1:20:39
     */
    public static <T extends WKEnum<T>> boolean  isExist(Class<T> t,String name){
        return null==getWKEnum(t, name);
    }
    
    /**
     * 获取WKEnum子类 <code>T</code> 中指定number的实例
     * @param t WKEnum的子类
     * @param number
     * @return
     * @author dwk
     * 2017年8月2日 下午1:21:02
     */
    public static <T extends WKEnum<T> > T getWKEnum(Class<T> t,int number){
        Set<T> set = WKEnum.getAll(t);
        T e = null;
        if(null!=set&&set.size()>0){
            for (T o : set) {
                if(o instanceof WKEnum){
                    if(number==((WKEnum)o).getNumber()){
                        e = o;
                        break;
                    }
                }
            }
        }
        return e;
    }
    
    /**
     * 获取WKEnum子类  <code>T</code> 中指定name的实例
     * @param t
     * @param number
     * @return
     * @author dwk
     * 2017年8月2日 下午1:21:02
     */
    public static <T extends WKEnum<T> > T getWKEnum(Class<T> t,String name){
        Set<T> set = WKEnum.getAll(t);
        T e = null;
        if(null!=set&&set.size()>0){
            for (T o : set) {
                if(o instanceof WKEnum){
                    if(name.equals(((WKEnum)o).getName())){
                        e = o;
                        break;
                    }
                }
            }
        }
        return e;
    }
    
    /**
     * 获取WKEnum子类中全部 <code>T</code> 的实例 
     * @param t
     * @return
     * @author dwk
     * 2017年8月2日 下午1:22:34
     */
    public static <T extends WKEnum<T> > Set<T> getAll(Class<T> t){
        String tClassName = t.getName();
        Set<T> set = new HashSet<T>();
        Field[] fields = t.getDeclaredFields();
        if(null!=fields&&fields.length>0){
            String fieldModifier =null;
            for (Field field : fields) {
                fieldModifier = Modifier.toString(field.getModifiers());
                
                if("public static final".equals(fieldModifier) && tClassName.equals(field.getType().getName())){
                    try {
                        set.add((T) field.get(t));
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            
        }
        
        return set;
        
    }
    
}
