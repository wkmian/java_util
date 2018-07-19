package com.wk.util.wkpage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wk.util.wkmap.WKHashMap;

/**
 *
 * @author dwk
 * @version 2017年7月27日 下午3:02:36
 */
public class WKPageResult<T> implements Serializable {
    
    private List<T> list;// 查询结果
    private int pageNo = 1; // 当前页数
    private int pageSize = 10; // 行数
    private int maxSize = 0; // 总条数
    private int maxPage = 0; // 总页数
    
    /**
     * 是否分页查询，false查询全部
     */
    private boolean isPage = true;
    
    /**
     * 是否查询总数 false不查询
     */
    private boolean isQueryCount = true;
    
    /**
     * 实体查询条件
     */
    private T condition;
    
    /**
     * 额外的查询参数
     */
    public final WKHashMap extraCondition = new WKHashMap();

    /**
     * 额外的东西，供传递参数使用
     */
    public final WKHashMap extra = new WKHashMap();
    
    
}
