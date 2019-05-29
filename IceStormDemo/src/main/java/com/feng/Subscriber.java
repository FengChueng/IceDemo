package com.feng;

//public class Subscriber extends Ice.Application {
//
//    public int run(String[] args) {
//        Ice.ObjectPrx obj = communicator().stringToProxy("DemoIceStorm/TopicManager");
//        IceStorm.TopicManagerPrx topicManager = IceStorm.TopicManagerPrxHelper
//                .checkedCast(obj);
//        System.out.println("topicManager = "+topicManager);
//        Ice.ObjectAdapter adapter = communicator().createObjectAdapter("WeatherMonitorAdapter");
////        Monitor monitor1 = new MonitorI("the first monitor");
////        Ice.ObjectPrx proxy1 = adapter.addWithUUID(monitor1).ice_oneway();
//
//        adapter.activate();
//        IceStorm.TopicPrx topic = null;
//        try {
//            topic = topicManager.retrieve("Weather");
//        } catch (IceStorm.NoSuchTopic ex) {
//            try
//            {
//                topic = topicManager.create("Weather");
//            }
//            catch(IceStorm.TopicExists it)
//            {
//                System.err.println("temporary failure, try again.");
//            }
//        }
//        java.util.Map qos = null;
//        try {
//            topic.subscribeAndGetPublisher(qos, proxy1);
//        } catch (AlreadySubscribed e) {
//            e.printStackTrace();
//        } catch (BadQoS e) {
//            e.printStackTrace();
//        }
//        communicator().waitForShutdown();
//        topic.unsubscribe(proxy1);
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        Subscriber app = new Subscriber();
//        System.exit(app.main("Server", args,"C:\\config.sub"));
//    }
//}