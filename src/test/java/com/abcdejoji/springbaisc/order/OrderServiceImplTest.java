package com.abcdejoji.springbaisc.order;

import com.abcdejoji.springbaisc.discount.*;
import com.abcdejoji.springbaisc.member.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "memberA", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());

        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}