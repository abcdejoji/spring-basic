package com.abcdejoji.springbaisc;

import com.abcdejoji.springbaisc.discount.*;
import com.abcdejoji.springbaisc.member.*;
import com.abcdejoji.springbaisc.order.*;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
