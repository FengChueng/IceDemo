package com.txmd.service;

import Ice.Current;
import com.txmd.generate.MessageModule._SmsDisp;

/**
 * Created by zhangyinglong on 2019/2/19.
 */
public class SmsServiceImpl extends _SmsDisp {
    @Override
    public boolean sendSms(String phone, Current __current) {
        System.out.println("准备发送短信至:"+phone);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("成功发送短信至:"+phone);
        return true;
    }
}
