package emre.hrms.business.abstracts;

import java.util.List;

import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	Result add(Employer employer);

	DataResult<List<Employer>> getAll();
}
