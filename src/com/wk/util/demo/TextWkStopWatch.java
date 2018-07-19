package com.wk.util.demo;

import com.wk.util.wkmonitoring.WKStopWatch;

/**
 *
 * @author dwk
 * @version 2017年6月19日 下午6:05:24
 */
public class TextWkStopWatch {
    public static void main(String[] args) throws Exception {
        WKStopWatch stopWatch = new WKStopWatch("test");
        
        stopWatch.start("任务测试");
        Thread.sleep(200);
        
        stopWatch.stopAndStart("进度测试");
        Thread.sleep(300);
        stopWatch.stop();
        
        stopWatch.printInfo();
        
        
    }
}
