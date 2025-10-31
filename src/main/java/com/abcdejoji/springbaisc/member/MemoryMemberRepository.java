package com.abcdejoji.springbaisc.member;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

}
