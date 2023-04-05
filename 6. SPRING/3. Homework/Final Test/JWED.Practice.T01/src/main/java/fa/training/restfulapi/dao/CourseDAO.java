package fa.training.restfulapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.restfulapi.entities.Course;

@Repository(value = "courseDAO")
public interface CourseDAO extends JpaRepository<Course, Integer> {

}
