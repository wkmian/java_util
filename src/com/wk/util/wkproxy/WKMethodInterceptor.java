package com.wk.util.wkproxy;

import java.lang.reflect.Method;

/**
 *
 * @author dwk
 * @version 2017年6月9日 下午5:51:06
 */
public interface WKMethodInterceptor {
    Object invoke(Object target, Method method, Object[] args) throws Throwable ;
}
