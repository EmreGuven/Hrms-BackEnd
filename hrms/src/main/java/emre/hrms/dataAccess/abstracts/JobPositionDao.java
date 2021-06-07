package emre.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import emre.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{

	JobPosition findByJobTitle(String title);
	
	JobPosition getById(int id);
}
