package com.txmd;

import Ice.Communicator;
import Ice.Util;
import com.txmd.generate.book.Message;
import com.txmd.generate.book.OnlineBookPrx;
import com.txmd.generate.book.OnlineBookPrxHelper;

/**
 * Created by zhangyinglong on 2019/2/20.
 */
public class RegistryClient {
    public static void main(String[] args) {
        bookTicketRegistry();
    }

    public static void bookTicketRegistry() {
        String [] config = {"--Ice.Default.Locator=IceGrid/Locator:tcp -h localhost -p 4061"};

        Communicator communicator = Util.initialize(config);

        Ice.ObjectPrx base = communicator.stringToProxy("OnlineBook@OnlineBookAdapter");
        if(base == null){
            throw new RuntimeException("cannot create proxy");
        }
        OnlineBookPrx onlineBookPrx = OnlineBookPrxHelper.checkedCast(base);
        Message msg = new Message();
        msg.name = "Feng";
        msg.type = 3;
        msg.price = 66;
        msg.valid = true;
        msg.content = "test icebox";
        Message message = onlineBookPrx.bookTicket(msg);
        System.out.println("server response: " + message.content);
    }
}
