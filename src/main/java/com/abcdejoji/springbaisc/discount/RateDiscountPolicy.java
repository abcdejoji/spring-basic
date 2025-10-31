package com.abcdejoji.springbaisc.discount;

import com.abcdejoji.springbaisc.annotation.*;
import com.abcdejoji.springbaisc.member.*;
import org.springframework.stereotype.*;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }

}
