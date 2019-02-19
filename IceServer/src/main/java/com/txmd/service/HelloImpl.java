package com.txmd.service;

import Ice.Current;
import com.txmd.generate.helloworld._HelloDisp;

/**
 * Created by zhangyinglong on 2019/2/18.
 */
public class HelloImpl extends _HelloDisp {
    @Override
    public void sayHello(int delay, Current __current) {
        System.out.println("客户端调用 sayHello" + delay);
    }

    @Override
    public String helloWorld(String name, Current __current) {
        System.out.println("客户端调用 helloWorld");
        return "hello world : " + name;
    }

    @Override
    public void shutdown(Current __current) {
        System.out.println("客户端调用 shutdown,关闭服务端");
    }
}
