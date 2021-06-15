package service.member;

import org.springframework.beans.factory.annotation.Autowired;

import repository.MemberRepository;

public class MemberDeleteService {
	
	@Autowired
	MemberRepository memberRepository;	
	public void memDel(String membId) {
		memberRepository.memDel(membId);
	}
}
