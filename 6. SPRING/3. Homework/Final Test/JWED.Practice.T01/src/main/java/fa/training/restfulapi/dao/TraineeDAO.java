package fa.training.restfulapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.training.restfulapi.entities.Trainee;

@Repository(value = "traineeDAO")
public interface TraineeDAO extends JpaRepository<Trainee, Integer> {
	@Query("SELECT t FROM Trainee t WHERE t.trainee_account = ?1 AND t.password = ?2")
	Trainee checkLogin(String trainee_account, String password);
}
