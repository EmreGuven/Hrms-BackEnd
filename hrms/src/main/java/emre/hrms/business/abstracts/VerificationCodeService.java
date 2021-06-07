package emre.hrms.business.abstracts;

import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {

	Result add(VerificationCode code);
}
