package fa.training.restfulapi.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fa.training.restfulapi.entities.Member;
import fa.training.restfulapi.response.ResponseTransfer;
import fa.training.restfulapi.services.MemberService;

@RestController
public class MemberController {
	private Logger logger = Logger.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	// Register new member
	@PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public Member register(@RequestParam String username, String password, @RequestBody Member member) {
		member.setUsername(username);
		member.setPassword(password);
		return memberService.saveMember(member);
	}

	// Check login
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseTransfer checkLogin(@RequestBody Member member) {
		logger.info("loading");
		Member mem = memberService.checkLogin(member);
		if (mem != null) {
			return new ResponseTransfer("Login successful - Wellcome to my page");
		}
		return new ResponseTransfer("Login failed - Please double check carefully");
	}

	// Add new member
	@PostMapping(value = "/add-new-member", produces = MediaType.APPLICATION_JSON_VALUE)
	public Member saveNewMember(@RequestBody Member member) {
		return memberService.saveMember(member);
	}

	// Update profile member
	@PutMapping("/update-member/{id}")
	public ResponseEntity<Member> updateMember(@PathVariable("id") Integer id, @RequestBody Member member)
			throws Exception {
		memberService.findMemberById(id).orElseThrow(() -> new Exception("Member not found: " + id));
		member.setId(id);
		final Member updatedProfile = memberService.saveMember(member);
		return ResponseEntity.ok(updatedProfile);
	}
}
