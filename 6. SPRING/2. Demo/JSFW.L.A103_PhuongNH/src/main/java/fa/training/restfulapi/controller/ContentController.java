package fa.training.restfulapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fa.training.restfulapi.entities.Content;
import fa.training.restfulapi.entities.Member;
import fa.training.restfulapi.services.ContentService;
import fa.training.restfulapi.services.MemberService;

@RestController
public class ContentController {
	private Logger logger = Logger.getLogger(ContentController.class);

	@Autowired
	private ContentService contentService;
	@Autowired
	private MemberService memberService;

	@PostMapping(value = "/add-content/member-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Content save(@PathVariable Integer id, @RequestBody Content content) {
		Optional<Member> member = memberService.findMemberById(id);
		content.setMember(member.get());
		return contentService.saveContent(content);
	}

	// Update Content
	@PutMapping(value = "/update-content/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Content> updateContent(@PathVariable("id") Integer id, @RequestBody Content content)
			throws Exception {
		memberService.findMemberById(id).orElseThrow(() -> new Exception("Content not found: " + id));
		Optional<Member> member = memberService.findMemberById(id);
		content.setMember(member.get());
		content.setId(id);
		final Content updatedContent = contentService.saveContent(content);
		return ResponseEntity.ok(updatedContent);
	}

	// Delete content
	@DeleteMapping("/delete-content/{id}")
	public Map<String, Boolean> delete(@PathVariable Integer id) throws Exception {
		contentService.findContentById(id).orElseThrow(() -> new Exception("Content not found: " + id));
		contentService.deleteContent(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Content has been removed", Boolean.TRUE);
		return response;
	}

	// Search content by id
	@GetMapping("/search-content/{id}")
	public Content searchContent(@PathVariable Integer id) throws Exception {
		Optional<Content> content = contentService.findContentById(id);
		return content.get();
	}

	// List all content
	@GetMapping(value = {"/list-content" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Content>> listCustomer() {
		return ResponseEntity.ok(contentService.findAll());
	}
}
