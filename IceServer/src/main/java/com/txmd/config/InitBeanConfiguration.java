package com.txmd.config;

import com.txmd.ice.factory.IceProperties;
import com.txmd.ice.factory.IceServerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangyinglong on 2019/2/22.
 */
@Configuration
@EnableConfigurationProperties(IceProperties.class)
public class InitBeanConfiguration {

    @Autowired
    private IceProperties iceProperties;

    @Bean
    public IceServerFactory iceServerFactory(){
        IceServerFactory iceServerFactory = new IceServerFactory();
        iceServerFactory.setIceProperties(iceProperties);
        iceServerFactory.init();
        return iceServerFactory;
    }

}
