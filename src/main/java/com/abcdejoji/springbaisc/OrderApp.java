package com.abcdejoji.springbaisc;

import com.abcdejoji.springbaisc.member.*;
import com.abcdejoji.springbaisc.order.*;
import org.slf4j.*;

public class OrderApp {

    private static final Logger log = LoggerFactory.getLogger(OrderApp.class);

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());

    }
}
