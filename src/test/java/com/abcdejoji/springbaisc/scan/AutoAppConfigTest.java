package com.abcdejoji.springbaisc.scan;

import com.abcdejoji.springbaisc.*;
import com.abcdejoji.springbaisc.member.*;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.*;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
