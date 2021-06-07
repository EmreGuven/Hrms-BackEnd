package emre.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emre.hrms.business.abstracts.JobAdvertService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.ErrorResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.core.utilities.results.SuccessDataResult;
import emre.hrms.core.utilities.results.SuccessResult;
import emre.hrms.dataAccess.abstracts.JobAdvertDao;
import emre.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList() {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllOpenJobAdvertList());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByOrderByPublishedAtAsc() {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllByOrderByPublishedAtAsc());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id) {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllOpenJobAdvertByEmployer(id));
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
		
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getById(id));
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}
	
	@Override
	public Result activeToPassive(int id) {
		
		if(getById(id) == null) {
			return new ErrorResult("Böyle bir iş ilanı yok");
		}
		
		if(getById(id).getData().isOpen() == false) {
			return new ErrorResult("Bu iş ilanı zaten pasif durumda");
		}
		
		JobAdvert jobAdvert = getById(id).getData();
		jobAdvert.setOpen(false);
		update(jobAdvert);
		
		return new SuccessResult("İş ilanı pasif duruma getirildi");
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		
		if(!checkIfNullField(jobAdvert)) {
			return new ErrorResult("Lütfen tüm alanları eksiksiz doldurunuz.");
		}
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş İlanı Eklendi");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş İlanı Güncellendi");
	}

	@Override
	public Result delete(int id) {
		
		this.jobAdvertDao.deleteById(id);
		return new SuccessResult("İş İlanı Silindi");
	}
	
	private boolean checkIfNullField(JobAdvert jobAdvert) {
		
		if(jobAdvert.getJobPosition() != null && jobAdvert.getDescription() != null && jobAdvert.getCity() != null
				&& jobAdvert.getOpenPositionCount() != 0) {
			return true;
		}
		return false;
		
	}

	


}
















