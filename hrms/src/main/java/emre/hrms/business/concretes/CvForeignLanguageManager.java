package emre.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emre.hrms.business.abstracts.CvForeignLanguageService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.core.utilities.results.SuccessDataResult;
import emre.hrms.core.utilities.results.SuccessResult;
import emre.hrms.dataAccess.abstracts.CvForeignLanguageDao;
import emre.hrms.entities.concretes.CvForeignLanguage;

@Service
public class CvForeignLanguageManager implements CvForeignLanguageService {

	private CvForeignLanguageDao cvForeignLanguageDao;
	
	@Autowired
	public CvForeignLanguageManager(CvForeignLanguageDao cvForeignLanguageDao) {
		super();
		this.cvForeignLanguageDao = cvForeignLanguageDao;
	}

	@Override
	public Result add(CvForeignLanguage cvForeignLanguage) {
		
		this.cvForeignLanguageDao.save(cvForeignLanguage);
		return new SuccessResult("Dil Bilgisi Eklendi");
	}

	@Override
	public Result update(CvForeignLanguage cvForeignLanguage) {
		
		this.cvForeignLanguageDao.save(cvForeignLanguage);
		return new SuccessResult("Dil Bilgisi Güncellendi");
	}

	@Override
	public Result delete(int id) {
		
		this.cvForeignLanguageDao.deleteById(id);
		return new SuccessResult("Dil Bilgisi Silindi");
	}

	@Override
	public DataResult<CvForeignLanguage> getById(int id) {
		
		return new SuccessDataResult<CvForeignLanguage>(this.cvForeignLanguageDao.getById(id));
	}

	@Override
	public DataResult<List<CvForeignLanguage>> getAll() {
		
		return new SuccessDataResult<List<CvForeignLanguage>>(this.cvForeignLanguageDao.findAll());
	}

	@Override
	public DataResult<List<CvForeignLanguage>> getAllByJobseekerId(int id) {
		
		return new SuccessDataResult<List<CvForeignLanguage>>(this.cvForeignLanguageDao.getAllByJobseeker_id(id));
	}

}
