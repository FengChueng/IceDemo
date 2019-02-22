package com.txmd.ice.factory;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>功 能：ICE参数实体类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年2月14日 上午11:52:11</p>
 *
 * @author 王建
 * @version 1.0
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "zeroc.ice.config")
public class IceProperties implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * <公共参数> ICE配置文件路径
     */
    private String iceCfgFilePath;

    /**
     * <公共参数> ICE应用名称
     */
    private String iceAppName;

    /**
     * <服务端参数> ICE适配器名称，默认为 IceAdapter
     */
    private String iceAdapterName = "IceAdapter";

    /**
     * <服务端参数> ICE服务键值对
     */
    private Map<String, String> iceServantMap;

    /**
     * <客户端参数> ICE客户端连接协议类型，可选项：tcp，udp，ssl，默认tcp
     */
    private String iceType = "tcp";

    /**
     * <客户端参数> ICE服务端IP
     */
    private String iceIP = "127.0.0.1";

    /**
     * <客户端参数> ICE服务端连接端口
     */
    private String icePort = "10000";

    /**
     * <客户端参数> ICE客户端服务代理类集合
     */
    private Map<String, String> icePrxMap;

    /**
     * <客户端参数> ICE连接超时时间，单位：毫秒，默认-1
     */
    private Integer iceTimeOut = -1;

    /**
     * <客户端参数> ICE连接是否启用SSL，默认false
     */
    private Boolean iceSecure = false;

}