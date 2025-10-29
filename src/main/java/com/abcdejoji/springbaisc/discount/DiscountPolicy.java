package com.abcdejoji.springbaisc.discount;

import com.abcdejoji.springbaisc.member.*;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
