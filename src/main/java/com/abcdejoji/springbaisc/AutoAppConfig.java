package com.abcdejoji.springbaisc;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)}
)
public class AutoAppConfig {

    //    @Bean
    //    public MemberRepository memoryMemberRepository() {
    //        return new MemoryMemberRepository();
    //    }
}
