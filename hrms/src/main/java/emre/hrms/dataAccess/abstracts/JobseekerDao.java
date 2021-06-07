package emre.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import emre.hrms.entities.concretes.Jobseeker;

public interface JobseekerDao extends JpaRepository<Jobseeker, Integer>{

	Jobseeker findJobSeekerByNationalId(String nationalId);
	
	Jobseeker getById(int id);
}
