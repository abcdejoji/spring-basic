package com.abcdejoji.springbaisc.bindfind.xml;

import com.abcdejoji.springbaisc.member.*;
import org.junit.jupiter.api.*;
import org.springframework.context.support.*;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class XmlAppContext {

    @Test
    void xmlAppContext() {

        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

    }

}
