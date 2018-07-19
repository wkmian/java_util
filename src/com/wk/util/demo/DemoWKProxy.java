package com.wk.util.demo;

import java.lang.reflect.Method;

import sun.misc.ProxyGenerator;

import com.wk.util.wkproxy.WKMethodInterceptor;
import com.wk.util.wkproxy.WKProxy;

/**
 *
 * @author dwk
 * @version 2017年6月9日 下午6:02:05
 */
public class DemoWKProxy {
        public static void main(String[] args) throws Exception {
            
            
            WKMethodInterceptor methodInterceptor = new WKMethodInterceptor() {
                
                @Override
                public Object invoke(Object target, Method method, Object[] args) throws Throwable {
                    Object result = null;
                    System.out.println("你是谁");
                    result = method.invoke(target, args);
                    System.out.println("原来是你啊");
                    return result;
                }
            };
            
            UserDaoImpl impl =  new UserDaoImpl();
            impl.id="asd";
            
            UserDao userDao =  (UserDao) WKProxy.bind(impl, methodInterceptor);
            userDao.sayHello();
            
            
        }
}
