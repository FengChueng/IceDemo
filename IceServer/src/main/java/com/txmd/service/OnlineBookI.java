package com.txmd.service;

import Ice.Communicator;
import Ice.Current;
import Ice.ObjectAdapter;
import IceBox.Service;
import com.txmd.generate.book.Message;
import com.txmd.generate.book._OnlineBookDisp;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by zhangyinglong on 2019/2/20.
 */
@Slf4j
public class OnlineBookI extends _OnlineBookDisp implements Service {

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
    public Message bookTicket(Message msg, Current __current) {
        log.info("bookTicket be called");

        log.debug("bookTicket called {}", msg.content);
        msg.content = "response";
        return msg;
    }
}
