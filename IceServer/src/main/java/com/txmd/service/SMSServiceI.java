package com.txmd.service;

import Ice.*;
import IceBox.Service;
import com.txmd.generate.book.Message;
import com.txmd.generate.book.OnlineBookPrx;
import com.txmd.generate.book.OnlineBookPrxHelper;
import com.txmd.generate.message._SMSServiceDisp;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by zhangyinglong on 2019/2/20.
 */
@Slf4j
public class SMSServiceI extends _SMSServiceDisp implements Service {

    private ObjectAdapter objectAdapter;

    @Override
    public void start(String name, Communicator communicator, String[] strings) {
        //创建objectAdapter 这里和service同名
        objectAdapter = communicator.createObjectAdapter(name);
        //创建servant并激活
        Ice.Object object = this;
        objectAdapter.add(object,communicator.stringToIdentity(name));
        objectAdapter.activate();
        log.info( "{} started ",name);
    }

    @Override
    public void stop() {
        log.info("{} stopped ",this.objectAdapter.getName());
        objectAdapter.destroy();
    }

    @Override
    public void sendSMS(String msg, Current __current) {
        log.info("server send msg: {}", msg);
        if("book".equals(msg)){
//            normalInvoke();
//            ObjectPrx onlineBookPrx = objectAdapter.getCommunicator().stringToProxy("OnlineBook@OnlineBookAdapter");

            String [] config = {"--Ice.Default.Locator=IceGrid/Locator:tcp -h localhost -p 4061"};
            Communicator communicator = Util.initialize(config);
            ObjectPrx onlineBookPrx = communicator.propertyToProxy("OnlineBook@OnlineBookAdapter");

            OnlineBookPrx onlineBook = OnlineBookPrxHelper.checkedCast(onlineBookPrx);
            Message message = new Message();
            message.name = "Feng";
            message.type = 3;
            message.price = 66;
            message.valid = true;
            message.content = "test icebox";
            Message messageResp = onlineBook.bookTicket(message);
            log.info("OnlineBook service response {}" ,messageResp.content);
        }

    }

    private void normalInvoke() {
        try {
            ObjectPrx onlineBookPrx = objectAdapter.getCommunicator().stringToProxy("OnlineBook");
            OnlineBookPrx onlineBook = OnlineBookPrxHelper.checkedCast(onlineBookPrx);
            Message message = new Message();
            message.name = "Feng";
            message.type = 3;
            message.price = 66;
            message.valid = true;
            message.content = "test icebox";
            Message messageResp = onlineBook.bookTicket(message);
            System.out.println(messageResp.content);
        } catch (LocalException e) {
            e.printStackTrace();
        } catch (Ice.Exception e){
            e.printStackTrace();
        }
    }
}
