package com.txmd.service;

import Ice.Current;
import com.txmd.generate.MailModule.AMD_MailAmd_sendMail;
import com.txmd.generate.MailModule._MailAmdDisp;

/**
 * Created by zhangyinglong on 2019/2/19.
 */
public class MailServiceImpl extends _MailAmdDisp {
    @Override
    public void sendMail_async(AMD_MailAmd_sendMail __cb, String phone, Current __current) {
        System.out.println("服务端发送邮箱至:" + phone);

        __cb.ice_response(true);
        System.out.println("响应");

    }
}
