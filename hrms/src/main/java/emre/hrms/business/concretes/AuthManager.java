package emre.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emre.hrms.business.abstracts.AuthService;
import emre.hrms.business.abstracts.EmployerService;
import emre.hrms.business.abstracts.JobseekerService;
import emre.hrms.business.abstracts.UserService;
import emre.hrms.business.abstracts.VerificationCodeService;
import emre.hrms.core.utilities.adapters.ValidationService;
import emre.hrms.core.utilities.results.ErrorResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.core.utilities.results.SuccessResult;
import emre.hrms.core.verification.VerificationService;
import emre.hrms.entities.concretes.Employer;
import emre.hrms.entities.concretes.Jobseeker;
import emre.hrms.entities.concretes.VerificationCode;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private EmployerService employerService;
	private JobseekerService jobSeekerService;
	private VerificationService verificationService;
	private ValidationService validationService;
	private VerificationCodeService verificationCodeService;

	
	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, JobseekerService jobSeekerService,
			VerificationService verificationService, ValidationService validationService,
			VerificationCodeService verificationCodeService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.jobSeekerService = jobSeekerService;
		this.verificationService = verificationService;
		this.validationService = validationService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {

		if (!checkIfNullInfoForEmployer(employer)) {

			return new ErrorResult("Eksik Bilgi Girdiniz. Lütfen Tüm Alanları Eksiksiz Doldurunuz");
		}

		if (!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebsite())) {

			return new ErrorResult("Geçersiz e-mail Adresi");
		}

		if (!checkIfEmailExists(employer.getEmail())) {

			return new ErrorResult(employer.getEmail() + " Bu e-mail Adresi Sisteme Kayıtlıdır");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {

			return new ErrorResult("Lütfen Şifreleri Aynı Girdiğinizden Emin Olun");
		}

		employerService.add(employer);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, employer.getId(), employer.getEmail());
		return new SuccessResult("Kayıt Olma İşlemi Başarıyla Tamamlandı");

	}

	@Override
	public Result registerJobSeeker(Jobseeker jobseeker, String confirmPassword) {

		if (checkIfRealPerson(Long.parseLong(jobseeker.getNationalId()), jobseeker.getFirstName(),
				jobseeker.getLastName(), jobseeker.getDateOfBirth().getYear()) == false) {
			return new ErrorResult("T.C Kimlik Numarası Doğrulanamadı");
		}

		if (!checkIfNullInfoForJobseeker(jobseeker, confirmPassword)) {

			return new ErrorResult("Eksik Bilgi Girdiniz. Lütfen Tüm Alanları Eksiksiz Doldurunuz");
		}

		if (!checkIfExistsTcNo(jobseeker.getNationalId())) {

			return new ErrorResult(jobseeker.getNationalId() + " Bu T.C Kimlik Numarası Sisteme Kayıtlıdır");
		}

		if (!checkIfEmailExists(jobseeker.getEmail())) {

			return new ErrorResult(jobseeker.getEmail() + " Bu e-mail Adresi Sisteme Kayıtlıdır");
		}

		
		jobSeekerService.add(jobseeker);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, jobseeker.getId(), jobseeker.getEmail());
		return new SuccessResult("Kayıt Olma İşlemi Başarıyla Tamamlandı");
	}

	

	private boolean checkIfNullInfoForEmployer(Employer employer) {

		if (employer.getCompanyName() != null && employer.getWebsite() != null && employer.getEmail() != null
				&& employer.getPhoneNumber() != null && employer.getPassword() != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

	
	
	private boolean checkIfNullInfoForJobseeker(Jobseeker jobSeeker, String confirmPassword) {

		if (jobSeeker.getFirstName() != null && jobSeeker.getLastName() != null && jobSeeker.getNationalId() != null
				&& jobSeeker.getDateOfBirth()!= null && jobSeeker.getPassword() != null && jobSeeker.getEmail() != null
				&& confirmPassword != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfExistsTcNo(String nationalId) {

		if (this.jobSeekerService.getJobSeekerByNationalId(nationalId).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean checkIfRealPerson(long nationalId, String firstName, String lastName, int yearOfBirth) {

		if (validationService.validateByMernis(nationalId, firstName, lastName, yearOfBirth)) {
			return true;
		}
		return false;
	}

	
	private boolean checkIfEmailExists(String email) {

		if (this.userService.getUserByEmail(email).getData() == null) {

			return true;
		}

		return false;
	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}
	
	private void verificationCodeRecord(String code, int id, String email) {
		
		VerificationCode verificationCode = new VerificationCode(id, code, false);
		this.verificationCodeService.add(verificationCode);
		System.out.println("Doğrulama Kodu Gönderildi :  " + email );
	
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


