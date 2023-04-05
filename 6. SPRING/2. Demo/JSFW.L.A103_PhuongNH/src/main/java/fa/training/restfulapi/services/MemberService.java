package fa.training.restfulapi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.restfulapi.dao.MemberDAO;
import fa.training.restfulapi.entities.Member;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberDAO memberDao;

	public Member saveMember(final Member member) {
		return memberDao.save(member);
	}

	public void deleteMember(final int id) {
		Member member = memberDao.findById(id).get();
		if (member != null) {
			memberDao.delete(member);
		}
	}

	public Optional<Member> findMemberById(final Integer id) {
		return memberDao.findById(id);
	}

	public List<Member> findAllMember() {
		return memberDao.findAll();
	}
	
	public Member checkLogin(Member member) {		
		return memberDao.checkLogin(member.getUsername(), member.getPassword());
	}

}
