package com.wk.util.wkuuid;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.wk.util.WKNumbers;

/**
 *
 * @author dwk
 * @version 2017年8月31日 下午1:29:26
 */
public final  class WKUUID {
    
    //禁止实例化
    private WKUUID(){}
    
    
    
    private static String digits(long val, int digits) {
        long hi = 1L << (digits * 4);
        return WKNumbers.toString(hi | (val & (hi - 1)),WKNumbers.MAX_RADIX).substring(1);
    }
  
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        StringBuilder sb = new StringBuilder(19);
        sb.append(digits(uuid.getMostSignificantBits()>>32,8));
        sb.append(digits(uuid.getMostSignificantBits()>>16,4));
        sb.append(digits(uuid.getMostSignificantBits(),4));
        sb.append(digits(uuid.getLeastSignificantBits()>>48,4));
        sb.append(digits(uuid.getLeastSignificantBits(),12));
        return sb.toString();
    }
    
    private static String getUUID2(){
        UUID uuid = UUID.randomUUID();
        StringBuilder sb = new StringBuilder(19);
        sb.append(digits(uuid.getMostSignificantBits()>>32,8));
        sb.append("-");
        sb.append(digits(uuid.getMostSignificantBits()>>16,4));
        sb.append("-");
        sb.append(digits(uuid.getMostSignificantBits(),4));
        sb.append("-");
        sb.append(digits(uuid.getLeastSignificantBits()>>48,4));
        sb.append("-");
        sb.append(digits(uuid.getLeastSignificantBits(),12));
        return sb.toString();
    }
    
    private static String getUUID3(){
        UUID uuid = UUID.randomUUID();
        String[] numbers = uuid.toString().split("-");
        StringBuilder sb = new StringBuilder(21);
        for (String number : numbers) {
            sb.append(WKNumbers.toString(WKNumbers.toNumber(number, 10), WKNumbers.MAX_RADIX));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
//        System.out.println(getUUID());
//        System.out.println(getUUID2());
//        System.out.println(getUUID3());
        System.out.println(WKNumbers.toNumber("010", 8));
        
    }
}
