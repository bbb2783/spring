package com.example.p1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
	@Transactional
	@Modifying
	@Query("update Member set pw=?2, email=?3 where id=?1")
	int updateMyinfo(String id, String pw, String email);
	boolean existsByNum1(String num1);
}