package emre.hrms.business.abstracts;

import java.util.List;

import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.CvProgrammingSkill;

public interface CvProgrammingSkillService {

	Result add(CvProgrammingSkill cvProgrammingSkill);
	
	Result update(CvProgrammingSkill cvProgrammingSkill);
	
	Result delete(int id);
	
	DataResult<CvProgrammingSkill> getById(int id);
	
	DataResult<List<CvProgrammingSkill>> getAll();
	
	DataResult<List<CvProgrammingSkill>> getAllByJobseekerId(int id);
}
