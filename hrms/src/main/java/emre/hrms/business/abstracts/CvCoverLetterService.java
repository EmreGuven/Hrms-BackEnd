package emre.hrms.business.abstracts;

import java.util.List;

import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.CvCoverLetter;

public interface CvCoverLetterService {

	Result add(CvCoverLetter cvCoverLetter);
	
	Result update(CvCoverLetter cvCoverLetter);
	
	Result delete(int id);
	
	DataResult<CvCoverLetter> getById(int id);
	
	DataResult<List<CvCoverLetter>> getAll();
}
