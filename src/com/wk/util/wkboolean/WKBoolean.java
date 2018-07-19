package com.wk.util.wkboolean;
/**
 * 用简单的0 1代表true false
 * @author dwk
 * @version 2017年5月23日 下午4:23:38
 */
public class WKBoolean {
    /**
     * 数字类型 1代表true
     */
    public static final int TRUE = 1;
    /**
     * 数字类型0 代表false
     */
    public static final int FALSE = 0;
    
    /**
     * 转换成WKBoolean
     * @param value
     * @return
     * @author dwk
     * 2017年5月23日 下午5:00:26
     */
    public static int convert2WKBoolean(boolean value){
        return value?TRUE:FALSE;
    }
    
    /**
     * 获取 非 值 <br />
     * >.value is null return TRUE
     * @param value
     * @return
     * @author dwk
     * 2017年5月23日 下午5:00:44
     */
    public static int getNotWKBoolean(Integer value){
        return null==value?TRUE:convert2WKBoolean(1==value);
    }
    
    /**
     * 将 0 1 数字转换成 boolean类型 <br />
     * >.value is null return FALSE
     * @param value
     * @return
     * @author dwk
     * 2017年5月31日 下午6:20:03
     */
    public static boolean getBoolean(Integer value){
        return null==value?false:1==value;
    }
}
