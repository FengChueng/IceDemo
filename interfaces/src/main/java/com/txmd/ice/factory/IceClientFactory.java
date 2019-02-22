package com.txmd.ice.factory;

import Ice.Communicator;
import Ice.InitializationData;
import Ice.ObjectPrx;
import Ice.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@Slf4j
public class IceClientFactory {

    /**
     * 存放所有服务代理对象
     */
    private ConcurrentMap<String, ObjectPrx> objPrxMap = new ConcurrentHashMap<String, ObjectPrx>();

    /**
     * ICE客户端参数
     */
    private IceProperties iceProperties;

    /**
     * 初始化ICE客户端连接
     */
    public void init() {
        try {
            // 前置条件判断

            // 移除所有映射关系，重新添加
            if (!objPrxMap.isEmpty()){
                objPrxMap.clear();
            }

            // 获取同一个ICE服务端下的所有服务代理对象
            Map<String, String> icePrxMap = iceProperties.getIcePrxMap();
            ObjectPrx refObjPrx = null;
            for (Map.Entry<String, String> entry : icePrxMap.entrySet()) {
                refObjPrx = getReflectObjPrx(entry.getKey(), entry.getValue());
                objPrxMap.put(entry.getKey(), refObjPrx);
            }
        } catch (Exception e) {
            log.error("初始化ICE客户端连接出错", e);
        }
    }

    /**
     * 销毁ICE客户端连接
     */
    public void destroy() {
        try {
            if (!CollectionUtils.isEmpty(objPrxMap)) {
                Communicator communicator = null;
                for (Map.Entry<String, ObjectPrx> entry : objPrxMap.entrySet()) {
                    // 获取每个ICE代理对象的连接器
                    communicator = entry.getValue().ice_getCommunicator();
                    // 关闭连接器
                    if (!communicator.isShutdown()){
                        communicator.shutdown();
                    }
                    // 销毁连接器
                    if (communicator != null){
                        communicator.destroy();
                    }
                }
                // 清空键值对集合
                objPrxMap.clear();
            }
        } catch (Exception e) {
            log.error("销毁ICE客户端连接出错", e);
        }
    }

    /**
     * 获取ICE最终连接代理类
     * <p>根据配置文件中的类全路径名，通过反射执行checkedCast方法获取代理对象</p>
     *
     * @param objPrxKey
     * @param className
     * @return
     */
    private ObjectPrx getReflectObjPrx(String objPrxKey, String className) {
        ObjectPrx refObjPrx = null;
        try {
            // 第四步：获取最终代理对象
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getMethod("checkedCast", ObjectPrx.class);
            // 因为 checkedCast 是代理类的静态方法，所以不需要 newInstance实例化对象
            refObjPrx = (ObjectPrx) method.invoke(clazz, getObjPrx(objPrxKey));
        } catch (Exception e) {
            log.error("获取ICE最终连接代理类出错", e);
        }
        return refObjPrx;
    }

    /**
     * 获取ICE连接代理类
     *
     * @param objPrxKey
     * @return
     */
    private ObjectPrx getObjPrx(String objPrxKey) {
        ObjectPrx objPrx = null;
        try {
            // 根据代理对象的连接Key获取连接端口
            String proxyKey = getProxyKey(objPrxKey);
            String proxyValue = getProxyValue(objPrxKey);

            // 第一步：设置ICE客户端连接属性
            InitializationData initData = new InitializationData();
            initData.properties = Util.createProperties();
            // 加载ICE客户端配置文件
            initData.properties.load(iceProperties.getIceCfgFilePath());
            // 设置客户端服务代理的监听地址
            initData.properties.setProperty(proxyKey, proxyValue);

            // 第二步：获取指定ICE服务的 Communicator
            Communicator communicator = Util.initialize(initData);

            // 第三步：获取代理对象
            objPrx = communicator.propertyToProxy(proxyKey).ice_twoway().ice_timeout(iceProperties.getIceTimeOut()).ice_secure(iceProperties.getIceSecure());
        } catch (Exception e) {
            log.error("获取ICE连接代理类出错", e);
        }
        return objPrx;
    }

    /**
     * 获取ICE客户端代理监听地址的键
     *
     * @param objPrxKey ICE服务标识
     * @return
     */
    private String getProxyKey(String objPrxKey) {
        return new StringBuilder().append(objPrxKey).append(".").append("Proxy").toString();
    }

    /**
     * ICE客户端监听的服务端口<br/>
     * 例如：hello:tcp -h 127.0.0.1 -p 10000
     */
    private static final String IceProxy = "$KEY$:$TYPE$ -h $IP$ -p $PORT$";

    /**
     * 获取ICE客户端代理监听地址的值
     *
     * @param objPrxKey ICE服务标识
     * @return
     */
    private String getProxyValue(String objPrxKey) {
        return IceProxy.replace("$KEY$", objPrxKey).replace("$TYPE$", iceProperties.getIceType()).replace("$IP$", iceProperties.getIceIP()).replace("$PORT$", iceProperties.getIcePort());
    }

    /**
     * 获取ICE代理对象
     *
     * @param objPrxKey
     * @return
     */
    public ObjectPrx getPrxByKey(String objPrxKey) {
        ObjectPrx objPrx = null;
        try {
            // 前置条件检查

            // ICE配置参数和代理对象集合中是否同时包含指定参数
            if (iceProperties.getIcePrxMap().containsKey(objPrxKey) && objPrxMap.containsKey(objPrxKey)) {
                objPrx = objPrxMap.get(objPrxKey);
            }
        } catch (Exception e) {
            log.error("获取ICE代理对象出错", e);
        }
        return objPrx;
    }

    /**
     * 获取ICE客户端参数
     *
     * @return
     */
    public IceProperties getIceProperties() {
        return iceProperties;
    }

    /**
     * 设置ICE客户端参数
     *
     * @param iceProperties
     */
    public void setIceProperties(IceProperties iceProperties) {
        this.iceProperties = iceProperties;
    }
}