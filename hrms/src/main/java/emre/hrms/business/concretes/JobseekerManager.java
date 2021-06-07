package emre.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emre.hrms.business.abstracts.CvCoverLetterService;
import emre.hrms.business.abstracts.CvExperienceService;
import emre.hrms.business.abstracts.CvForeignLanguageService;
import emre.hrms.business.abstracts.CvImagesService;
import emre.hrms.business.abstracts.CvLinkService;
import emre.hrms.business.abstracts.CvProgrammingSkillService;
import emre.hrms.business.abstracts.CvSchoolService;
import emre.hrms.business.abstracts.JobseekerService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.core.utilities.results.SuccessDataResult;
import emre.hrms.core.utilities.results.SuccessResult;
import emre.hrms.dataAccess.abstracts.JobseekerDao;
import emre.hrms.entities.concretes.Jobseeker;
import emre.hrms.entities.dtos.CvDto;

@Service
public class JobseekerManager implements JobseekerService {

	private JobseekerDao jobseekerDao;
	private CvSchoolService cvSchoolService;
	private CvProgrammingSkillService cvProgrammingSkillService;
	private CvLinkService cvLinkService;
	private CvImagesService cvImageService;
	private CvForeignLanguageService cvForeignLanguageService;
	private CvExperienceService cvExperienceService;
	private CvCoverLetterService cvCoverLetterService;
	
	
	public JobseekerManager(JobseekerDao jobseekerDao, CvSchoolService cvSchoolService,
			CvProgrammingSkillService cvProgrammingSkillService, CvLinkService cvLinkService,
			CvImagesService cvImageService, CvForeignLanguageService cvForeignLanguageService,
			CvExperienceService cvExperienceService, CvCoverLetterService cvCoverLetterService) {
		super();
		this.jobseekerDao = jobseekerDao;
		this.cvSchoolService = cvSchoolService;
		this.cvProgrammingSkillService = cvProgrammingSkillService;
		this.cvLinkService = cvLinkService;
		this.cvImageService = cvImageService;
		this.cvForeignLanguageService = cvForeignLanguageService;
		this.cvExperienceService = cvExperienceService;
		this.cvCoverLetterService = cvCoverLetterService;
	}	

	@Override
	public Result add(Jobseeker jobSeeker) {
		
		this.jobseekerDao.save(jobSeeker);
		return new SuccessResult("İş Arayan Bilgisi Eklendi");
	}
	
	@Override
	public Result update(Jobseeker jobSeeker) {
		
		this.jobseekerDao.save(jobSeeker);
		return new SuccessResult("İş Arayan Bilgisi Güncellendi");
	}

	@Override
	public Result delete(int id) {
		
		this.jobseekerDao.deleteById(id);
		return new SuccessResult("İş Arayan Bilgisi Silindi");
	}
	
	@Override
	public DataResult<CvDto> getCvById(int id) {
		
		Jobseeker jobseeker = this.jobseekerDao.getById(id);
		CvDto cv = new CvDto();
		cv.schools = jobseeker.getSchools();
		cv.programmingSkills = jobseeker.getProgrammingSkills();
		cv.links = jobseeker.getLinks();
		cv.languages = jobseeker.getLanguages();
		cv.image = jobseeker.getImage();
		cv.experiences = jobseeker.getExperiences();
		return new SuccessDataResult<CvDto>(cv);
	}

	@Override
	public DataResult<List<Jobseeker>> getAll() {
		
		return new SuccessDataResult<List<Jobseeker>>(this.jobseekerDao.findAll());
	}

	@Override
	public DataResult<Jobseeker> getJobSeekerByNationalId(String nationalId) {
		
		return new SuccessDataResult<Jobseeker>(this.jobseekerDao.findJobSeekerByNationalId(nationalId));
	}

	@Override
	public DataResult<Jobseeker> getById(int id) {
		
		return new SuccessDataResult<Jobseeker>(this.jobseekerDao.getById(id));
	}


}
