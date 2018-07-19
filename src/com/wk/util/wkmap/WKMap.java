package com.wk.util.wkmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 封装并增强map的实现
 * @author dwk
 * @version 2017年7月7日 下午3:29:09
 */
@SuppressWarnings({ "unchecked","rawtypes" })
public class WKMap {
    private Map map = new HashMap();
    
    public <T> T getValue(Object key){
        return (T) map.get(key);
    }
    
    public <T> T getValue(Object key,T isNullValue){
        return map.containsKey(key)?getValue(key):isNullValue;
    }
    
    public void putAll(Map t) {
        map.putAll(t);
    }
    
    /**
     * chainSet
     * 链式(chain)set
     * @param key
     * @param value
     * @return
     * @author dwk
     * 2017年7月13日 下午4:08:48
     */
    public WKMap chainSet(Object key ,Object value){
        getSet(key, value);
        return this;
    }
    
    /**
     * 获取key值并赋值
     * @param key
     * @param value
     * @return
     * @author dwk
     * 2017年7月13日 下午4:09:52
     */
    public Object getSet(Object key ,Object value){
        return map.put(key, value);
    }
    
    /**
     * chain风格自增,
     * 将 key 中储存的数字值增一
     * 如果 key 不存在，那么 key 的值会先被初始化为  int 0 ，然后再执行 INCR 操作。
     * @return
     * @author dwk
     * 2017年7月13日 下午4:18:33
     */
    public WKMap chainIncr(Object key){
        return chainIncrBy(key, 1);
    }
    
    public WKMap chainIncrBy(Object key,int incr){
        //如果存在性能问题，再考试是转换成int还是long
        getSet(key, getValue(key, 0L)+incr);
        return this;
    }
    
    /**
     * 是否存在key
     * @param key
     * @return
     * @author dwk
     * 2017年7月13日 下午5:06:21
     */
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }
    
    
    public Object del(Object key){
        return map.remove(key);
    }
    
    /**
     * 链式删除元素
     * @param key
     * @return
     * @author dwk
     * 2017年7月13日 下午6:23:12
     */
    public WKMap chainDel(Object key){
        del(key);
        return this;
    }
    
    public Set<Entry> entrySet() {
        return map.entrySet();
    }
    
    public Set keySet() {
        return map.keySet();
    }
    
    public int size(){
        return map.size();
    }
    
    public Collection values() {
        return map.values();
    }
    
    
    public WKMap chainClear(){
        map.clear();
        return this;
    }
    public boolean isEmpty(){
        return map.isEmpty();
    }
    
}
