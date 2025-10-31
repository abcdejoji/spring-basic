package com.abcdejoji.springbaisc.autowired;

import com.abcdejoji.springbaisc.member.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.lang.*;

import java.util.*;

public class AutowiredTest {

    @Test
    void autowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {

        @Autowired(required = false)
        public void setNoBean1(Member member1) {
            System.out.println("member1 = " + member1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member2) {
            System.out.println("member2 = " + member2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member3) {
            System.out.println("member3 = " + member3);
        }
    }
}
