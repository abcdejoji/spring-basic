package com.abcdejoji.springbaisc;

import com.abcdejoji.springbaisc.member.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

public class MemberApp {

    public static void main(String[] args) {
        //        AppConfig appConfig = new AppConfig();
        //        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
