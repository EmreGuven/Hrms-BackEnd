package emre.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emre.hrms.business.abstracts.CvExperienceService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.core.utilities.results.SuccessDataResult;
import emre.hrms.core.utilities.results.SuccessResult;
import emre.hrms.dataAccess.abstracts.CvExperienceDao;
import emre.hrms.entities.concretes.CvExperience;

@Service
public class CvExperienceManager implements CvExperienceService {

	private CvExperienceDao cvExperienceDao;
	
	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao) {
		super();
		this.cvExperienceDao = cvExperienceDao;
	}

	@Override
	public Result add(CvExperience cvExperience) {
		
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("İş Tecrübesi Eklendi");
	}

	@Override
	public Result update(CvExperience cvExperience) {
		
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("İş Tecrübesi Güncellendi");
	}

	@Override
	public Result delete(int id) {
		
		this.cvExperienceDao.deleteById(id);
		return new SuccessResult("İş Tecrübesi Silindi");
	}

	@Override
	public DataResult<CvExperience> getById(int id) {
		
		return new SuccessDataResult<CvExperience>(this.cvExperienceDao.getById(id));
	}

	@Override
	public DataResult<List<CvExperience>> getAll() {
		
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.findAll());
	}

	@Override
	public DataResult<List<CvExperience>> getAllByJobseekerId(int id) {
		
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByJobseeker_id(id));
	}

	@Override
	public DataResult<List<CvExperience>> getAllByJobseekerIdOrderByEndAtDesc(int id) {
		
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByJobseeker_idOrderByEndAtDesc(id));
	}

}
