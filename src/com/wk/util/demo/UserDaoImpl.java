package com.wk.util.demo;

import com.wk.util.wkstring.WKStringUtil;

/**
 *
 * @author dwk
 * @version 2017年6月9日 下午6:33:43
 */
public class UserDaoImpl implements UserDao {

    public String id ;

    @Override
    public void sayHello() {
        System.out.println("id : "+ id);
        System.out.println("我是dwk");
    }

}
