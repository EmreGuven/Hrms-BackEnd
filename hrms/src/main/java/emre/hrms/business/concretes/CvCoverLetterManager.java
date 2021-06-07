package emre.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emre.hrms.business.abstracts.CvCoverLetterService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.core.utilities.results.SuccessDataResult;
import emre.hrms.core.utilities.results.SuccessResult;
import emre.hrms.dataAccess.abstracts.CvCoverLetterDao;
import emre.hrms.entities.concretes.CvCoverLetter;

@Service
public class CvCoverLetterManager implements CvCoverLetterService {

	private CvCoverLetterDao cvCoverLetterDao;
	
	@Autowired
	public CvCoverLetterManager(CvCoverLetterDao cvCoverLetterDao) {
		super();
		this.cvCoverLetterDao = cvCoverLetterDao;
	}

	@Override
	public Result add(CvCoverLetter cvCoverLetter) {
		
		this.cvCoverLetterDao.save(cvCoverLetter);
		return new SuccessResult("Ön Yazı Eklendi");
	}

	@Override
	public Result update(CvCoverLetter cvCoverLetter) {
		
		this.cvCoverLetterDao.save(cvCoverLetter);
		return new SuccessResult("Ön Yazı Güncellendi");
	}

	@Override
	public Result delete(int id) {
		
		this.cvCoverLetterDao.deleteById(id);
		return new SuccessResult("Ön Yazı Silindi");
	}

	@Override
	public DataResult<CvCoverLetter> getById(int id) {
		
		return new SuccessDataResult<CvCoverLetter>(this.cvCoverLetterDao.getById(id));
	}

	@Override
	public DataResult<List<CvCoverLetter>> getAll() {
		
		return new SuccessDataResult<List<CvCoverLetter>>(this.cvCoverLetterDao.findAll());
	}

}
