package com.txmd.callback;

import Ice.AsyncResult;
import Ice.Callback;
import Ice.LocalException;
import com.txmd.generate.MessageModule.SmsPrx;

/**
 * Created by zhangyinglong on 2019/2/19.
 */
public class SmsCallback extends Callback{
    @Override
    public void completed(AsyncResult r) {
        SmsPrx smsPrx = (SmsPrx) r.getProxy();
        try {
            boolean result = smsPrx.end_sendSms(r);
            System.out.println("发送结果:" + result);
        } catch (LocalException e) {
            System.out.println("exception is : " + e);
        }
    }
}
