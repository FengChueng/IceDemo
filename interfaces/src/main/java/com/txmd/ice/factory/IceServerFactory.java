package com.txmd.ice.factory;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class IceServerFactory extends Ice.Application {

    /**
     * ICE服务端参数
     */
    private IceProperties iceProperties;

    /**
     * ICE服务配置
     */
    @Override
    public int run(String[] args) {
        int status = 0;
        try {
            // 获取ICE服务端点
            String endpoints = communicator().getProperties().getProperty("IceServer");
            // 获取指定的ICE服务适配器
            Ice.ObjectAdapter adapter = communicator().createObjectAdapterWithEndpoints(iceProperties.getIceAdapterName(), endpoints);
            // 设置适配器中的服务标识
            for (Map.Entry<String, String> entry : iceProperties.getIceServantMap().entrySet()){
                adapter.add(reflection(entry.getValue()), communicator().stringToIdentity(entry.getKey()));
            }
            // 启动指定服务
            adapter.activate();
            // 阻塞线程，保持服务开启状态
            communicator().waitForShutdown();
        } catch (Exception e) {
            status = -1;
            log.error("ICE服务配置出错", e);
        }
        return status;
    }

    public Ice.Object reflection(String beanName) throws Exception {
        Ice.Object bean =  null;
        try {
            Class<?> clz = Class.forName(beanName);
            bean = Ice.Object.class.cast(clz.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("初始化失败");
        }
        return bean;
    }

    /**
     * 启动ICE服务端
     */
    public void init() {
        // ICE服务启动线程
        new Thread() {
            @Override
            public void run() {
                try {
                    // 前置条件判断
//                    Assert.requireNonEmpty(iceProperties, "ICE配置文件路径不能为空");
//                    Assert.requireNonEmpty(iceProperties.getIceCfgFilePath(), "ICE服务端配置文件路径不能为空");
//                    Assert.requireNonEmpty(iceProperties.getIceServantMap(), "ICE服务名称集合不能为空");
                    // 启动ICE服务端
//                    if (LOG.isInfoEnabled())
//                        LOG.info("ICE服务端线程已启动...");

                    main(iceProperties.getIceAppName(), new String[]{}, iceProperties.getIceCfgFilePath());
                } catch (Exception e) {
                    log.error("ICE服务端线程启动出错", e);
                }
            }
        }.start();
    }

    /**
     * 停止ICE服务端
     */
    public void destroy() {
        try {
            if (null != communicator()) {
                communicator().destroy();
            }
        } catch (Exception e) {
            log.error("停止ICE服务端线程出错", e);
        }
    }

    /**
     * 获取ICE服务端参数
     *
     * @return
     */
    public IceProperties getIceProperties() {
        return iceProperties;
    }

    /**
     * 设置ICE服务端参数
     *
     * @param iceProperties
     */
    public void setIceProperties(IceProperties iceProperties) {
        this.iceProperties = iceProperties;
    }
}