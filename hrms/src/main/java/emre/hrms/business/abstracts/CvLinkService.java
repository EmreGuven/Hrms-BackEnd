package emre.hrms.business.abstracts;

import java.util.List;

import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.CvLink;

public interface CvLinkService {

	Result add(CvLink cvLink);
	
	Result update(CvLink cvLink);
	
	Result delete(int id);
	
	DataResult<CvLink> getById(int id);
	
	DataResult<List<CvLink>> getAll();
	
	DataResult<List<CvLink>> getAllByJobseekerId(int id);
}
