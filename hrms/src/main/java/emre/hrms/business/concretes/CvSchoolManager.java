package emre.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emre.hrms.business.abstracts.CvSchoolService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.core.utilities.results.SuccessDataResult;
import emre.hrms.core.utilities.results.SuccessResult;
import emre.hrms.dataAccess.abstracts.CvSchoolDao;
import emre.hrms.entities.concretes.CvSchool;

@Service
public class CvSchoolManager implements CvSchoolService {

	private CvSchoolDao cvSchoolDao;
	
	@Autowired
	public CvSchoolManager(CvSchoolDao cvSchoolDao) {
		super();
		this.cvSchoolDao = cvSchoolDao;
	}

	@Override
	public Result add(CvSchool cvSchool) {
		
		this.cvSchoolDao.save(cvSchool);
		return new SuccessResult("Okul Bilgisi Eklendi");
	}

	@Override
	public Result update(CvSchool cvSchool) {
		
		this.cvSchoolDao.save(cvSchool);
		return new SuccessResult("Okul Bilgisi Güncellendi");
	}

	@Override
	public Result delete(int id) {
		
		this.cvSchoolDao.deleteById(id);
		return new SuccessResult("Okul Bilgisi Silindi");
	}

	@Override
	public DataResult<CvSchool> getById(int id) {
		
		return new SuccessDataResult<CvSchool>(this.cvSchoolDao.getById(id));
	}

	@Override
	public DataResult<List<CvSchool>> getAll() {
		
		return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.findAll());
	}

	@Override
	public DataResult<List<CvSchool>> getAllByJobseekerIdOrderByEndAtDesc(int id) {
		
		return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.getAllByJobseeker_idOrderByEndAtDesc(id));
	}

	@Override
	public DataResult<List<CvSchool>> getAllByJobseekerId(int id) {
		
		return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.getAllByJobseeker_id(id));
	}

}
