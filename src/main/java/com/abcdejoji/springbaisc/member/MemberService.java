package com.abcdejoji.springbaisc.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
