package fa.training.restfulapi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.restfulapi.dao.TraineeDAO;
import fa.training.restfulapi.entities.Trainee;

@Service
@Transactional
public class TraineeService {
	
	@Autowired
	private TraineeDAO traineeDao;
	
	public Trainee saveTrainee(final Trainee trainee) {
		return traineeDao.save(trainee);
	}

	public void deleteTrainee(final Integer id) {
		Trainee trainee = traineeDao.findById(id).get();
		if (trainee != null) {
			traineeDao.delete(trainee);
		}
	}

	public Optional<Trainee> findTraineeById(final Integer id) {
		return traineeDao.findById(id);
	}

	public List<Trainee> findAllMember() {
		return traineeDao.findAll();
	}
	
	public Trainee checkLogin(Trainee trainee) {		
		return traineeDao.checkLogin(trainee.getTrainee_account(), trainee.getPassword());
	}
}
