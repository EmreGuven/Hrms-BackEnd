package emre.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import emre.hrms.entities.concretes.CvSchool;

public interface CvSchoolDao extends JpaRepository<CvSchool, Integer> {

	CvSchool getById(int id);
	
	List<CvSchool> getAllByJobseeker_idOrderByEndAtDesc(int id);
	
	List<CvSchool> getAllByJobseeker_id(int id);
}
