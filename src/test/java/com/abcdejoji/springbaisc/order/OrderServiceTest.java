package com.abcdejoji.springbaisc.order;

import com.abcdejoji.springbaisc.*;
import com.abcdejoji.springbaisc.member.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}