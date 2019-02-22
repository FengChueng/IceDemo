package com.txmd.ice.proxy;

import com.txmd.generate.book.Message;
import com.txmd.generate.book.OnlineBookPrx;
import com.txmd.generate.book._OnlineBookOperationsNC;
import com.txmd.ice.factory.IceClientHolder;

/**
 * Created by zhangyinglong on 2019/2/22.
 */
public class OnlineBookService extends IceClientHolder<OnlineBookPrx> implements _OnlineBookOperationsNC {
    @Override
    protected OnlineBookPrx getProviderPrx() {
        return getObjPrx("OnlineBook");
    }

    @Override
    public Message bookTicket(Message msg) {
        Message message = null;
        try {
            message = getProviderPrx().bookTicket(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
