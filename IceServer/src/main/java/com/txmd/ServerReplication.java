package com.txmd;

import Ice.Application;
import Ice.ObjectAdapter;
import com.txmd.service.HelloImpl;
import com.txmd.service.MailServiceImpl;
import com.txmd.service.SmsServiceImpl;

/**
 * Created by zhangyinglong on 2019/2/18.
 */
public class ServerReplication extends Application{
    @Override
    public int run(String[] strings) {
        ObjectAdapter serverAdapter = communicator().createObjectAdapter("Hello");
        serverAdapter.add(new HelloImpl(),Ice.Util.stringToIdentity("hello"));

        //ami
        serverAdapter.add(new SmsServiceImpl(),Ice.Util.stringToIdentity("sendSms"));

        //amd
        serverAdapter.add(new MailServiceImpl(),Ice.Util.stringToIdentity("sendMail"));

        serverAdapter.activate();
        System.out.println("服务已启动,端口:10001");
        communicator().waitForShutdown();
        return 0;
    }

    public static void main(String[] args) {
        ServerReplication server = new ServerReplication();
        int status = server.main("Server", args, "config.server.replication");
        System.exit(status);
        System.out.println("服务已退出,端口:10000");
    }

}
