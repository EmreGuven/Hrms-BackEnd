package emre.hrms.business.abstracts;

import java.util.List;

import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.Jobseeker;
import emre.hrms.entities.dtos.CvDto;

public interface JobseekerService {

	Result add(Jobseeker jobSeeker);
	
	Result update(Jobseeker jobSeeker);
	
	Result delete(int id);
	
	DataResult<Jobseeker> getById(int id);
	
	DataResult<List<Jobseeker>> getAll();
	
	DataResult<Jobseeker> getJobSeekerByNationalId(String nationalId);
	
	DataResult<CvDto> getCvById(int id);
}
