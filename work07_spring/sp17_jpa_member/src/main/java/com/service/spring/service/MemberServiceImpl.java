package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Member;
import com.service.spring.model.MemberRepository;
import com.service.spring.service.MemberService;


@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepository memberRepository;
	
	public void registerMember(Member member) {
		memberRepository.save(member);
	}

	public List<Member> showAllMember() {
		return memberRepository.findAll();
	}

	public Member findByIdMember(String id) {
		return memberRepository.findByIdMember(id);
	}

	public Member login(Member member) {
		return memberRepository.login(member);
	}

	public void updateMember(Member member) {
		memberRepository.save(member);
	}

	public String idExist(String id) {
		return memberRepository.idExist(id);
	}

}
