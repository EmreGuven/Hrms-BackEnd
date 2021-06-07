package emre.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emre.hrms.business.abstracts.VerificationCodeService;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.core.utilities.results.SuccessResult;
import emre.hrms.dataAccess.abstracts.VerificationCodeDao;
import emre.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result add(VerificationCode code) {
		
		this.verificationCodeDao.save(code);
		return new SuccessResult("Code has been saved.");
	}

	

}
