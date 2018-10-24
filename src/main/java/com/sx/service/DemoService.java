package com.sx.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * <p>Title:service </p>
 * <p>Description:</p>
 * Created with IntelliJ IDEA.
 * User: maxiucheng
 * Date: 2018/3/13
 * Time: 9:47
 */
@Service
public class DemoService implements InitializingBean{

    public String  sayHello(){
        return "Hello World";
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("我被 实例 化了 demoservice");
    }
}
