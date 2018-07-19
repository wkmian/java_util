package com.wk.design;

import java.util.Date;

import com.wk.util.wkenum.WKEnum;

/**
 * 一个实体类不同类型的统计计数
 * 利用纵向查询 转成 一条数据
 * @author dwk
 * @version 2017年8月9日 上午10:15:32
 */
public class BeanTypeCount {
    public static final class Type extends WKEnum<Type>{

        /**
         * 点赞数
         */
        public static final Type likesCount = new Type(1,"点赞");
        
        /**
         * 阅读数
         */
        public static final Type readCount = new Type(2,"阅读");
        
        
        public Type(int number, String name) {
            super(number, name);
        }
        
    }
    
    
    private String id;
    
    /**
     * 表id
     */
    private String tblId;
    
    /**
     * 表类型
     */
    private String tblType;
    
    /**
     * 统计类型
     * @see Type
     */
    private Integer type;
    
    /**
     * 统计总值
     */
    private Long count;
    
    /**
     * 创建时间
     */
    private Date ct;
    
    /**
     * 修改时间
     */
    private Date et;
    
    
    
}
