package com.wk.utilbate.wkif;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dwk
 * @version 2018年6月5日 下午4:27:23
 */
public class WKIf implements Cloneable {
    
    private HashMap<String,WKIfHandler> map = null;
    
    //默认不是克隆对象
    private boolean isClone = false;
    
    
    
    private WKIf(String[] pks){
        map = new HashMap<String, WKIfHandler>();
        for (String pk : pks) {
            map.put(pk, null);
        }
    }
    
    private WKIf(List<String> pks){
        map = new HashMap<String, WKIfHandler>();
        for (String pk : pks) {
            map.put(pk, null);
        }
    }
    
    
    
    public static WKIf create(String[] pks){
        return new WKIf(pks);
    }
    
    public static WKIf create(List<String> pks){
        return new WKIf(pks);
    }
    
    
    public WKIf addIf(String pk,WKIfHandler handler){
        map.put(pk, handler);
        return this;
    }
    
    
    public void execute(String value){
        WKIfHandler handler = map.get(value);
        if(null!=handler){
            handler.handler();
        }
    }
    
    
    public WKIf getOneInstance(){
        WKIf wkIf = null;
        try {
            wkIf = (WKIf) super.clone();
            wkIf.map = (HashMap<String, WKIfHandler>) this.map.clone();
            wkIf.isClone = true;
        } catch (CloneNotSupportedException e) {
        }
        return wkIf;
    }
    
    
    
    
//    public Object assessInt(int a,int b){
//        
//        return null;
//    }
}
