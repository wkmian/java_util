package com.wk.util.demo;

import java.util.Set;

import com.wk.util.wkenum.WKEnum;

/**
 * 
 * @author dwk
 * @version 2017年8月2日 上午10:30:48
 */
public class Video {
    /**
     * 视频的状态
     * @author dwk
     * @version 2017年8月2日 下午1:53:54
     */
    public static class Status extends WKEnum<Status>{
        
        public static final Status Wait = new Status(1, "等待","你猜猜");
        public static final Status Success = new Status(2, "成功","我猜猜");
        
        public Status(int number, String name, String extra) {
            super(number, name);
            this.extra = extra;
        }
        
        /**
         * 拓展字段
         */
        private String extra ;
        
        /**
         * @return the extra
         */
        public String getExtra() {
            return extra;
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println("成功的状态 "+Status.Success.getNumber());
        
        System.out.println("遍历 Status有哪些状态===");
        Set<Status> statuses = Status.getAll(Status.class);
        for (Status status : statuses) {
            System.out.println(status.toString());
        }
        
        System.out.println("查询指定的Status===");
        
        Status status = Status.getWKEnum(Status.class, 1);
        System.out.println(status);
        
        System.out.println("判断是否相等===");
        System.out.println(status==Status.Wait);
        
        
        System.out.println(Status.Success==Status.Wait.Success.Success.Wait.Success);
        
    }
    
    
}
