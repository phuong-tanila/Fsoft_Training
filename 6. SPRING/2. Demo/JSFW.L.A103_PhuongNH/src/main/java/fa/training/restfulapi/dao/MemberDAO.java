package fa.training.restfulapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import fa.training.restfulapi.entities.Member;


@Repository(value = "memberDAO")
public interface MemberDAO  extends JpaRepository<Member, Integer>{
	
	@Query("SELECT u FROM Member u WHERE u.username = ?1 AND u.password = ?2")
	Member checkLogin(String username, String password);

}
