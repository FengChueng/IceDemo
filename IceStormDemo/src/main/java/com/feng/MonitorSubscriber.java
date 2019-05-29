package com.feng;

import Ice.Communicator;
import Ice.Util;
import IceStorm.AlreadySubscribed;
import IceStorm.BadQoS;
import IceStorm.InvalidSubscriber;
import com.feng.MMonitor.MonitorI;

import java.util.HashMap;

/**
 * @class_name:
 * @package:
 * @describe: TODO
 * @author: zhangfeng
 * @creat_date: 2019/5/29
 * @creat_time: 19:34
 **/
public class MonitorSubscriber {

    public static void main(String[] args)
    {
        Communicator communicator = Util.initialize();
        Ice.ObjectPrx obj = communicator.stringToProxy("IceStorm/TopicManager:tcp -p 9999");
        IceStorm.TopicManagerPrx topicManager = IceStorm.TopicManagerPrxHelper.checkedCast(obj);

//        Ice.ObjectAdapter adapter = communicator.createObjectAdapter("MonitorAdapter");
        Ice.ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("MonitorAdapter","tcp:udp");

        MonitorI monitor = new MonitorI();
        Ice.ObjectPrx proxy = adapter.addWithUUID(monitor).ice_oneway();
        adapter.activate();

        IceStorm.TopicPrx topic = null;
        try {
            topic = topicManager.retrieve("Weather");
        }
        catch (IceStorm.NoSuchTopic ex) {
            // Error! No topic found!
            try {
                topic = topicManager.create("Weather");
            } catch (IceStorm.TopicExists e) {
                // Another client created the topic.
            }
        }

        java.util.Map qos = new HashMap();
//            qos.put("reliability", "ordered");
        try {
            topic.subscribeAndGetPublisher(qos, proxy);
        } catch (AlreadySubscribed alreadySubscribed) {
            alreadySubscribed.printStackTrace();
        } catch (BadQoS badQoS) {
            badQoS.printStackTrace();
        } catch (InvalidSubscriber invalidSubscriber) {
            invalidSubscriber.printStackTrace();
        }
        communicator.waitForShutdown();
        topic.unsubscribe(proxy);
    }

}
