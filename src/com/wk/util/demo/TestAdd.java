package com.wk.util.demo;

import com.wk.util.wkmonitoring.WKStopWatch;

/**
 *
 * @author dwk
 * @version 2017年7月13日 下午5:29:49
 */
public class TestAdd {
    public static void main(String[] args) {
        int loopCount = 1000000000;//
        int a =1234567;
        long b = 1;
        WKStopWatch stopWatch = new WKStopWatch("int long 加减效率比较");
        
        stopWatch.start("int ++ 测试 ");
        for (int i = 0; i < loopCount; i++) {
            a++;
        }
        stopWatch.stopAndStart("int -- 测试");
        for (int i = 0; i < loopCount; i++) {
            a--;
        }
        
        stopWatch.stopAndStart("long ++ 测试");
        for (int i = 0; i < loopCount; i++) {
            b++;
        }
        stopWatch.stopAndStart("long -- 测试");
        for (int i = 0; i < loopCount; i++) {
            b--;
        }
        stopWatch.stopAndStart("long ++ 测试");
        for (int i = 0; i < loopCount; i++) {
            b++;
        }
        stopWatch.stop();
        stopWatch.printInfo();
        
    }
}
