package com.txmd.callback;

import Ice.LocalException;
import com.txmd.generate.MessageModule.Callback_Sms_sendSms;

/**
 * Created by zhangyinglong on 2019/2/19.
 */
public class SmsCallbackTypeSafe extends Callback_Sms_sendSms{
    @Override
    public void response(boolean arg) {
        System.out.println("发送结果:" + arg);
    }

    @Override
    public void exception(LocalException __ex) {
        System.out.println("发送异常,exception is : " + __ex);
    }
}
