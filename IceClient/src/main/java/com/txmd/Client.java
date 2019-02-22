package com.txmd;

import Ice.Application;
import com.txmd.generate.MailModule.MailAmdPrx;
import com.txmd.generate.MailModule.MailAmdPrxHelper;
import com.txmd.generate.MessageModule.SmsPrx;
import com.txmd.generate.MessageModule.SmsPrxHelper;
import com.txmd.generate.book.Message;
import com.txmd.generate.book.OnlineBookPrx;
import com.txmd.generate.book.OnlineBookPrxHelper;
import com.txmd.generate.helloworld.HelloPrx;
import com.txmd.generate.helloworld.HelloPrxHelper;

/**
 * Created by zhangyinglong on 2019/2/18.
 */
public class Client extends Application{

    class ShutdownHook extends Thread {
        @Override
        public void run() {
            communicator().destroy();
            System.out.println("destroy communicator");
        }
    }


    @Override
    public int run(String[] args) {
        // 注册ShutdownHook，关闭应用时销毁Communicator实例
        setInterruptHook(new ShutdownHook());
        // 通过config.client中的Hello.Proxy，构造通用Proxy对象
        helloProxy();

//        sendSms();

//        sendMail();

//        bookTicket();




        // 测试ShutdownHook
        communicator().waitForShutdown();
        return 0;
    }

    private void bookTicketRegistry() {
        Ice.ObjectPrx base = communicator().propertyToProxy("OnlineBook@OnlineBookAdapter");
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

    private void bookTicket() {
        Ice.ObjectPrx base = communicator().propertyToProxy("OnlineBook.Proxy");
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

    private void sendMail() {
        Ice.ObjectPrx base = communicator().propertyToProxy("Mail.Proxy");


        if(base == null){
            throw new RuntimeException("cannot create proxy");
        }
        MailAmdPrx mailAmdPrx = MailAmdPrxHelper.checkedCast(base);
        System.out.println("发送邮箱");

        int i = 0;
        while (i++ < 100){
            mailAmdPrx.begin_sendMail("18380586504",
                (result) -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("发送结果:" + result);
                },
                (ex) -> {
                    System.out.println("发送失败:" + ex);
                });
            System.out.println("发送结束");
        }
    }

    private void sendSms() {
        Ice.ObjectPrx base = communicator().propertyToProxy("Sms.Proxy");
        if(base == null){
            throw new RuntimeException("cannot create proxy");
        }
        SmsPrx smsPrx = SmsPrxHelper.checkedCast(base);
        System.out.println("发送短信");
        smsPrx.begin_sendSms("18380586504",
            (result) -> {
                System.out.println("发送结果:" + result);
            },
            (ex) -> {
                System.out.println("发送失败:" + ex);
            });
        System.out.println("发送结束");
    }

    private void helloProxy() {
        Ice.ObjectPrx base = communicator().propertyToProxy("Hello.Proxy");
        HelloPrx helloPrx = HelloPrxHelper.checkedCast(base);
        helloPrx.sayHello(1000);

        int i =0;
        long start = System.currentTimeMillis();
        while (i<1000000){
            String txmd = helloPrx.helloWorld("txmd");
            System.out.println("response:" + i++);
        }
        System.out.println( "spend:"  + (System.currentTimeMillis()-start)/1000);
        helloPrx.shutdown();
    }

    public static void main(String[] args) {
        int status = 0;
        try {
            Client client = new Client();
            client.main("Client",args,"config.client");

        } catch (Ice.LocalException iceEx) {
            iceEx.printStackTrace();
            status = 1;
        } catch (java.lang.Exception e){
            e.printStackTrace();
            status = 1;
        }
        finally {
            if(communicator() != null){
                communicator().destroy();
            }
        }
        System.exit(status);
    }
}
