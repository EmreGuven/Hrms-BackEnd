package emre.hrms.business.abstracts;

import java.util.List;

import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	Result add(JobPosition jobPosition);
	
	DataResult<List<JobPosition>> getAll();
	
	DataResult<JobPosition> getJobByTitle(String title);
}
