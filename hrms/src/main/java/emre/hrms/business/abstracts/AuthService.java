package emre.hrms.business.abstracts;

import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.Employer;
import emre.hrms.entities.concretes.Jobseeker;

public interface AuthService {

	Result registerEmployer(Employer employer, String confirmPassword);
	
	Result registerJobSeeker(Jobseeker jobSeeker, String confirmPassword);
}
