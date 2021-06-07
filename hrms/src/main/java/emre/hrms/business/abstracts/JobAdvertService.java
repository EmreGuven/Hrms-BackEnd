package emre.hrms.business.abstracts;

import java.util.List;

import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {

	DataResult<List<JobAdvert>> getAllOpenJobAdvertList();
	
	DataResult<List<JobAdvert>> getAllByOrderByPublishedAtAsc();
	
	DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id);
	
	DataResult<JobAdvert> getById(int id);
	
	DataResult<List<JobAdvert>> getAll();
	
	Result activeToPassive(int id);
	
	Result add(JobAdvert jobAdvert);
	
	Result update(JobAdvert jobAdvert);
	
	Result delete(int id);
}
