package com.abcdejoji.springbaisc.order;

import com.abcdejoji.springbaisc.annotation.*;
import com.abcdejoji.springbaisc.discount.*;
import com.abcdejoji.springbaisc.member.*;
import org.springframework.stereotype.*;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
