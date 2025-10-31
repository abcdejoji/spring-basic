package com.abcdejoji.springbaisc;

import com.abcdejoji.springbaisc.member.*;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)}
)
public class AutoAppConfig {

    @Bean
    public MemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }
}
