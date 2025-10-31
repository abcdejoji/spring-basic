package com.abcdejoji.springbaisc.autowired;

import com.abcdejoji.springbaisc.*;
import com.abcdejoji.springbaisc.discount.*;
import com.abcdejoji.springbaisc.member.*;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice1 = discountService.discount(member, 10000, "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice1).isEqualTo(1000);

        int discountPrice2 = discountService.discount(member, 20000, "rateDiscountPolicy");
        assertThat(discountPrice2).isEqualTo(2000);

    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {
            return policyMap.get(discountCode).discount(member, price);
        }
    }
}
