package com.wk.util.wkmap;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author dwk
 * @version 2017年7月13日 下午6:31:39
 */
@SuppressWarnings({ "unchecked","rawtypes" })
public class WKHashMap extends HashMap {
    
    /**
     * 获取value,返回类型自动根据接收类型适应
     * @param key
     * @return
     * @author dwk
     * 2017年7月14日 上午10:31:35
     */
    public <T> T getValue(Object key){
        return getValue(key, null);
    }
    
    /**
     * 获取value 返回类型和Class类型强制保持一致
     * @param key
     * @param t
     * @return
     * @author dwk
     * 2017年7月14日 上午10:34:26
     */
    
    public <T> T getValue(Object key,T isNullValue,Class<T> t){
        return getValue(key,isNullValue);
    }
    
    /**
     * 获取value ,当value不存在并且是null的时候返回isNullValue，并返回和isNullValue一致的类型
     * @param key
     * @param isNullValue
     * @return
     * @author dwk
     * 2017年7月14日 上午10:41:02
     */
    public <T> T getValue(Object key,T isNullValue){
        return (T) super.getOrDefault(key, isNullValue);
    }
    
    public WKHashMap chainPut(Object key,Object value){
        super.put(key, value);
        return this;
    }
    
    /**
     * 链式自增默认自增1
     * @param key
     * @return
     * @author dwk
     * 2017年7月13日 下午7:05:38
     */
    public WKHashMap chainIncr(Object key){
        return chainIncrBy(key, 1);
    }
    
    /**
     * 链式自增，自增量为incr
     * @param key
     * @param incr 目前只能是int类型,否则会破坏原value的数据类型
     * @return
     * @author dwk
     * 2017年7月13日 下午7:06:16
     */
    public WKHashMap chainIncrBy(Object key,int incr){
        Object value = getValue(key);
        if(null==value){
            chainPut(key, incr);
        }else if( value instanceof Short ){
            chainPut(key, (short)value + incr );
        }else if( value instanceof Integer ){
            chainPut(key, (int)value + incr );
        }else if(value instanceof Long){
            chainPut(key, (long)value + incr );
        }else if(value instanceof Double){
            chainPut(key, (double)value + incr );
        }else if(value instanceof Float){
            chainPut(key, (float)value + incr );
        }
        return this;
    }
    
    public WKHashMap chainRemove(Object key){
        super.remove(key);
        return this;
    }
    
    public WKHashMap chainClear(){
        super.clear();
        return this;
    } 
    
    @Override
    public Set<Entry> entrySet() {
        return super.entrySet();
    }
    
    public String getString(){
        
        return null;
    }
    
    public Integer getInt(){
        
        return null;
    }
    
    public Long getLong(){
        
        return null;
    }
    
    public Double getDouble(){
        return null;
    }
    
    
    
    
    

    
}
