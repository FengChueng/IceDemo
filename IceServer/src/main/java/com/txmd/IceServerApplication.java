package com.txmd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangyinglong on 2019/2/22.
 */
@Slf4j
@SpringBootApplication
public class IceServerApplication implements CommandLineRunner {

    public static void main(String[] args) throws InterruptedException {
//        SpringApplication.run(IceServerApplication.class,args);
        ApplicationContext ctx = new SpringApplicationBuilder().sources(IceServerApplication.class).web(WebApplicationType.NONE).run(args);

        final CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                closeLatch.countDown();
            }
        });
        closeLatch.await();
    }

    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Joining thread, you can press Ctrl+C to shutdown application");
//        Thread.currentThread().join();
    }
}
