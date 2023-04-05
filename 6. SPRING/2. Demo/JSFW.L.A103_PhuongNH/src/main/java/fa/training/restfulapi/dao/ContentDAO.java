package fa.training.restfulapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.restfulapi.entities.Content;

@Repository(value = "contentDAO")
public interface ContentDAO extends JpaRepository<Content, Integer>{

}
