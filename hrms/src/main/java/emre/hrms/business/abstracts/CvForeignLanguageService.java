package emre.hrms.business.abstracts;

import java.util.List;

import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.CvForeignLanguage;

public interface CvForeignLanguageService {

	Result add(CvForeignLanguage cvForeignLanguage);
	
	Result update(CvForeignLanguage cvForeignLanguage);
	
	Result delete(int id);
	
	DataResult<CvForeignLanguage> getById(int id);
	
	DataResult<List<CvForeignLanguage>> getAll();
	
	DataResult<List<CvForeignLanguage>> getAllByJobseekerId(int id);
}
