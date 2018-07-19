package com.wk.util.demo;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 *
 * @author dwk
 * @version 2017年6月9日 下午6:02:29
 */
public class TestObj {
    public String name;
    
    public void sayName(){
        System.out.println(name);
    }
    
    
    
    public static void main(String[] args) {
        TestObj obj = new TestObj();
        obj.name = "我是猫";
        
        Enhancer enhancer =new Enhancer();  
        enhancer.setSuperclass(TestObj.class);
        enhancer.setCallback(new MethodInterceptor() {
            
            @Override
            public Object intercept(Object paramObject, Method paramMethod,
                    Object[] paramArrayOfObject, MethodProxy paramMethodProxy)
                    throws Throwable {
                System.out.println(1);
                paramMethodProxy.invokeSuper(paramObject, paramArrayOfObject);
//                obj.sayName();
                System.out.println(2);
                return null;
            }
        });
        
        TestObj targetObject2=(TestObj)enhancer.create();  
        
        targetObject2.name = "我是猫";
        
        targetObject2.sayName();
    }
}
