package emre.hrms.business.abstracts;

import java.util.List;

import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.CvExperience;

public interface CvExperienceService {

	
    Result add(CvExperience cvExperience);
	
	Result update(CvExperience cvExperience);
	
	Result delete(int id);
	
	DataResult<CvExperience> getById(int id);
	
	DataResult<List<CvExperience>> getAll();
	
	DataResult<List<CvExperience>> getAllByJobseekerId(int id);
	
	DataResult<List<CvExperience>> getAllByJobseekerIdOrderByEndAtDesc(int id);
}
