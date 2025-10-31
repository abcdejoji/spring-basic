package com.abcdejoji.springbaisc.singleton;

import org.junit.jupiter.api.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

import static org.assertj.core.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);

        // ThreadA: B사용자 20000원 주문
        //        statefulService2.order("userB", 20000);

        // ThreadA: 사용자A 주문 금액 조회

        assertThat(userAPrice).isEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}