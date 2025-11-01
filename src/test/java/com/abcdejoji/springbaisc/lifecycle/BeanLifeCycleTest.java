package com.abcdejoji.springbaisc.lifecycle;

import org.junit.jupiter.api.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

        @Bean
        public NetworkClient newNetworkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.com");
            return networkClient;
        }
    }

}
