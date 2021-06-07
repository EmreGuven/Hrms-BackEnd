package emre.hrms.business.abstracts;

import java.util.List;

import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.CvSchool;

public interface CvSchoolService {

	Result add(CvSchool cvSchool);
	
	Result update(CvSchool cvSchool);
	
	Result delete(int id);
	
	DataResult<CvSchool> getById(int id);
	
	DataResult<List<CvSchool>> getAll();
	
	DataResult<List<CvSchool>> getAllByJobseekerIdOrderByEndAtDesc(int id);
	
	DataResult<List<CvSchool>> getAllByJobseekerId(int id);
}
