package com.lguplus.fleta.domain.study;

import com.lguplus.fleta.data.dto.study.MemberSearchCond;
import com.lguplus.fleta.data.entity.study.Member;
import com.lguplus.fleta.provider.jpa.study.MemberJpaEmRepository;
import com.lguplus.fleta.provider.jpa.study.MemberJpaRepository;
import com.lguplus.fleta.repository.study.MemberRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberJpaEmRepository memberJpaEmRepository;

    @Override
    public Optional<Member> getMember(Integer id) {
        return memberJpaRepository.findById(id);
    }

    @Override
    public List<Member> getMembers() {
        return memberJpaRepository.findAll();
    }

    @Override
    public List<Member> getMembersByEmail(String email) {
        return memberJpaRepository.findByEmail(email);
    }

    @Override
    public List<Member> getMembersByCond(MemberSearchCond cond) {
        return memberJpaEmRepository.getMembersByCond(cond);
    }

    @Override
    public void joinMember(Member member) {
        memberJpaRepository.save(member);
    }

    @Override
    public void leaveMember(Integer id) {
        memberJpaRepository.deleteById(id);
    }
}
