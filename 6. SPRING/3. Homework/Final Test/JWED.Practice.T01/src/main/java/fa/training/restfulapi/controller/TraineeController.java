package fa.training.restfulapi.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fa.training.restfulapi.entities.Trainee;
import fa.training.restfulapi.response.ResponseTransfer;
import fa.training.restfulapi.services.TraineeService;

@RestController
public class TraineeController {
	private Logger logger = Logger.getLogger(TraineeController.class);

	@Autowired
	private TraineeService traineeService;

	// Register new trainee
	@PostMapping(value = "/trainee-register", produces = MediaType.APPLICATION_JSON_VALUE)
	public Trainee register(@RequestParam String trainee_account, String password, @RequestBody Trainee trainee) {
		trainee.setTrainee_account(trainee_account);
		trainee.setPassword(password);
		return traineeService.saveTrainee(trainee);
	}

	// Check login
	@PostMapping(value = "/trainee-login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseTransfer checkLogin(@RequestBody Trainee trainee) {
		logger.info("loading");
		Trainee tr = traineeService.checkLogin(trainee);
		if (tr != null) {
			return new ResponseTransfer("Login successful - Please select your courses!");
		}
		return new ResponseTransfer("Login failed - Please double check carefully!");
	}

	// Update profile trainee
	@PutMapping("/update-trainee/{id}")
	public ResponseEntity<Trainee> updateTrainee(@PathVariable("id") Integer id, @RequestBody Trainee trainee)
			throws Exception {
		traineeService.findTraineeById(id).orElseThrow(() -> new Exception("Trainee not found: " + id));
		trainee.setTrainee_id(id);
		final Trainee updatedProfile = traineeService.saveTrainee(trainee);
		return ResponseEntity.ok(updatedProfile);
	}
}
