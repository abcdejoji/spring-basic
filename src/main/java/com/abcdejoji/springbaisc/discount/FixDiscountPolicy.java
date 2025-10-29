package com.abcdejoji.springbaisc.discount;

import com.abcdejoji.springbaisc.member.*;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFIxAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFIxAmount;
        }
        return 0;
    }

}
