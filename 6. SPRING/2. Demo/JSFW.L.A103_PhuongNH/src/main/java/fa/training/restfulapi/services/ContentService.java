package fa.training.restfulapi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.restfulapi.dao.ContentDAO;
import fa.training.restfulapi.entities.Content;

@Service
@Transactional
public class ContentService {

	@Autowired
	private ContentDAO contentDao;

	public List<Content> findAll() {
		return contentDao.findAll();
	}

	public Optional<Content> findContentById(final Integer id) {
		return contentDao.findById(id);
	}

	public Content saveContent(final Content content) {
		return contentDao.save(content);
	}

	public void deleteContent(final Integer id) {
		Content content = contentDao.findById(id).get();
		if (content != null) {
			contentDao.delete(content);
		}
	}
}
