package com.feng;

import Ice.Communicator;
import Ice.Util;
import com.feng.MMonitor.Measurement;
import com.feng.MMonitor.MonitorPrx;
import com.feng.MMonitor.MonitorPrxHelper;

import java.util.concurrent.TimeUnit;

/**
 * @class_name:
 * @package:
 * @describe: TODO
 * @author: zhangfeng
 * @creat_date: 2019/5/29
 * @creat_time: 19:37
 **/
public class MonitorPublisher {
    public static void main(String[] args) {

        Communicator communicator = Util.initialize();

        Ice.ObjectPrx obj = communicator.stringToProxy("IceStorm/TopicManager:tcp -p 9999");
        IceStorm.TopicManagerPrx topicManager = IceStorm.TopicManagerPrxHelper.checkedCast(obj);

//        IceStorm.FinderPrx finder = IceStorm.FinderPrxHelper.checkedCast(obj);
//        IceStorm.TopicManagerPrx topicManager = finder.getTopicManager();


        IceStorm.TopicPrx topic = null;
        while (topic == null) {
            try {
                topic = topicManager.retrieve("Weather");
            } catch (IceStorm.NoSuchTopic ex) {
                System.err.println(ex);
                try {
                    topic = topicManager.create("Weather");
                } catch (IceStorm.TopicExists e) {
                    // Another client created the topic.
                }
            }
        }

        Ice.ObjectPrx pub = topic.getPublisher().ice_oneway();
        MonitorPrx monitor = MonitorPrxHelper.uncheckedCast(pub);
        while (true) {
            Measurement m = getMeasurement();
            // Sent to all subscribers
            monitor.report(m);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static Measurement getMeasurement() {
        Measurement measurement = new Measurement("test",1.0f, (short) 1,0.0f);
        return measurement;
    }
}
