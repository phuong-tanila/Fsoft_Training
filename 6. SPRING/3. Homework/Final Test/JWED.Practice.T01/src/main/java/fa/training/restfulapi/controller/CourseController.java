package fa.training.restfulapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fa.training.restfulapi.entities.Course;
import fa.training.restfulapi.entities.Trainee;
import fa.training.restfulapi.services.CourseService;
import fa.training.restfulapi.services.TraineeService;

@RestController
public class CourseController {
	private Logger logger = Logger.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;
	@Autowired
	private TraineeService traineeService;

	// Add course
	@PostMapping(value = "/add-course/trainee-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Course save(@PathVariable Integer id, @RequestBody Course course) {
		Optional<Trainee> tr = traineeService.findTraineeById(id);
		course.setTrainee(tr.get());
		return courseService.saveCourse(course);
	}

	// Delete course
	@DeleteMapping("/delete-course/{id}")
	public Map<String, Boolean> delete(@PathVariable Integer id) throws Exception {
		courseService.findCourseById(id).orElseThrow(() -> new Exception("Course not found: " + id));
		courseService.deleteCourse(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("The course has been removed", Boolean.TRUE);
		return response;
	}

	// Update course
	@PutMapping(value = "/update-course/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> updateContent(@PathVariable("id") Integer id, @RequestBody Course course)
			throws Exception {
		traineeService.findTraineeById(id).orElseThrow(() -> new Exception("Course not found: " + id));
		Optional<Trainee> tr = traineeService.findTraineeById(id);
		course.setTrainee(tr.get());
		course.setCourse_id(id);
		final Course updatedCourse = courseService.saveCourse(course);
		return ResponseEntity.ok(updatedCourse);
	}

	// Search course by id
	@GetMapping("/search-course/{id}")
	public Course searchContent(@PathVariable Integer id) throws Exception {
		logger.info("loading");
		Optional<Course> content = courseService.findCourseById(id);
		return content.get();
	}

	// List all course
	@GetMapping(value = { "/list-course" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Course>> listCustomer() {
		return ResponseEntity.ok(courseService.findAll());
	}

}
