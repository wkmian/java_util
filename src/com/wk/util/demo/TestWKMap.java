package com.wk.util.demo;

import java.util.Map.Entry;

import com.wk.util.wkmap.WKMap;

/**
 *
 * @author dwk
 * @version 2017年7月13日 下午6:00:00
 */
public class TestWKMap {
    public static void main(String[] args) {
        WKMap wkMap = new WKMap();
        wkMap.chainSet("a", 1).chainSet("b", 2).chainSet("c", 3).chainIncr("d").chainIncrBy("d", 2);
        
        for (Entry entry : wkMap.entrySet()) {
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
    }
}
