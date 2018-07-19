package com.wk.design;

import java.util.Date;

/**
 * BeanTypeCount 用户操作日志  查询用户是否操作数据，例如：用户是否点赞
 * @author dwk
 * @version 2017年8月9日 上午10:24:08
 */
public class BeanTypeCountLog {
    
    private String id;
    
    /**
     * 这里=冗余存储 方便查询
     */
    private String tblId;
    
    /**
     * 这里=冗余存储 方便查询
     */
    private Integer tblType;
    
    /**
     * 这里=冗余存储 方便查询
     * @see BeanTypeCount.Type
     */
    private Integer type;
    
    /**
     * 操作用户
     */
    private String userid;
    
    /**
     * 创建时间
     */
    private Date ct;
    
    /**
     * 是否删除
     * 用户删除即取消该类型，例如：取消赞
     */
    private Integer isDelete;
    
}
