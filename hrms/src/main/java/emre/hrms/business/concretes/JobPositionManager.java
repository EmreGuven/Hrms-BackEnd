package emre.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emre.hrms.business.abstracts.JobPositionService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.ErrorResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.core.utilities.results.SuccessDataResult;
import emre.hrms.core.utilities.results.SuccessResult;
import emre.hrms.dataAccess.abstracts.JobPositionDao;
import emre.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositonDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositonDao) {
		super();
		this.jobPositonDao = jobPositonDao;
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		if(getJobByTitle(jobPosition.getJobTitle()).getData() !=null) {
			return new ErrorResult(jobPosition.getJobTitle() + "Bu İş Pozisyonu Sisteme Kayıtlıdır");
		}
		this.jobPositonDao.save(jobPosition);
		return new SuccessResult("İş Pozisyonu Eklendi");
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositonDao.findAll());
	}

	@Override
	public DataResult<JobPosition> getJobByTitle(String title) {
		
		return new SuccessDataResult<JobPosition>(this.jobPositonDao.findByJobTitle(title));
	}

}
