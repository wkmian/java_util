package com.wk.util.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wk.util.wkmap.WKHashMap;

/**
 *
 * @author dwk
 * @version 2017年7月13日 下午6:38:16
 */
public class TestWKHashMap {
    public static void main(String[] args) {
        WKHashMap map = new WKHashMap();
        map.chainPut("a", 2).chainPut("s", 3).chainIncrBy("a", 4).chainIncrBy("e", 2)
        .chainPut("as", true);
        
        for (Entry entry : map.entrySet()) {
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
        if(map.getValue("as",null,boolean.class)){
            System.out.println(true);
        }
        
    }
}
