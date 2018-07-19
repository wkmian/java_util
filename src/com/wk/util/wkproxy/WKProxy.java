package com.wk.util.wkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author dwk
 * @version 2017年6月9日 下午5:34:49
 */
public class WKProxy  {
    
    private WKProxy(){};
    
    private static WKProxy instance;
    
    private static WKProxy getInstance(){
        if(null==instance){
            synchronized (WKProxy.class) {
                if(null==instance){
                    instance = new WKProxy();
                }
            }
        }
        return instance;
    }
    
    
    public static Object bind(Object proxyObj,WKMethodInterceptor methodInterceptor){
        DynamicProxyHandler proxy = WKProxy.getInstance().new DynamicProxyHandler();
        Object o = proxy.bind(proxyObj,methodInterceptor); 
        return o;
        
    }
    
    
    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxyObj; //被代理对象
        private WKMethodInterceptor methodInterceptor;
        
        public Object bind(Object proxyObj,WKMethodInterceptor methodInterceptor){
            this.proxyObj =proxyObj;
            this.methodInterceptor = methodInterceptor;
            return Proxy.newProxyInstance(proxyObj.getClass().getClassLoader(), 
                    proxyObj.getClass().getInterfaces(), 
                    this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            return methodInterceptor.invoke(proxyObj, method, args);
        }
    }
    
    
   
    
}
