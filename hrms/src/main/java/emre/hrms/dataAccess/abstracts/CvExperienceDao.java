package emre.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import emre.hrms.entities.concretes.CvExperience;

public interface CvExperienceDao extends JpaRepository<CvExperience, Integer> {

	CvExperience getById(int id);
	
	List<CvExperience> getAllByJobseeker_idOrderByEndAtDesc(int id);
	
	List<CvExperience> getAllByJobseeker_id(int id);
}
