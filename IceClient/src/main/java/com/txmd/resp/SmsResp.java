package com.txmd.resp;

import Ice.Callback_Object_ice_isA;
import Ice.LocalException;

/**
 * Created by zhangyinglong on 2019/2/19.
 */
public class SmsResp extends Callback_Object_ice_isA {
    @Override
    public void response(boolean __ret) {
        System.out.println("发送结果:" + __ret);
    }

    @Override
    public void exception(LocalException __ex) {
        System.out.println("发送异常,exception is : " + __ex);
    }
}
