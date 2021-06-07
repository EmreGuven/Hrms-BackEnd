package emre.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import emre.hrms.entities.concretes.CvForeignLanguage;

public interface CvForeignLanguageDao extends JpaRepository<CvForeignLanguage, Integer> {

	CvForeignLanguage getById(int id);
	
	List<CvForeignLanguage> getAllByJobseeker_id(int id);
	
	
}
