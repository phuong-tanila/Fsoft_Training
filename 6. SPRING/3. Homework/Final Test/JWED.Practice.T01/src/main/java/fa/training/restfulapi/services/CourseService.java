package fa.training.restfulapi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.restfulapi.dao.CourseDAO;
import fa.training.restfulapi.entities.Course;

@Service
@Transactional
public class CourseService {

	@Autowired
	private CourseDAO courseDao;

	public Course saveCourse(final Course course) {
		return courseDao.save(course);
	}

	public List<Course> findAll() {
		return courseDao.findAll();
	}

	public Optional<Course> findCourseById(final Integer id) {
		return courseDao.findById(id);
	}

	public void deleteCourse(final Integer id) {
		Course course = courseDao.findById(id).get();
		if (course != null) {
			courseDao.delete(course);
		}
	}
}
