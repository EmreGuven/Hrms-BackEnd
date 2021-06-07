package emre.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emre.hrms.business.abstracts.CvLinkService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.core.utilities.results.SuccessDataResult;
import emre.hrms.core.utilities.results.SuccessResult;
import emre.hrms.dataAccess.abstracts.CvLinkDao;
import emre.hrms.entities.concretes.CvLink;

@Service
public class CvLinkManager implements CvLinkService {

	private CvLinkDao cvLinkDao;
	
	@Autowired
	public CvLinkManager(CvLinkDao cvLinkDao) {
		super();
		this.cvLinkDao = cvLinkDao;
	}

	@Override
	public Result add(CvLink cvLink) {
		
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Link Eklendi");
	}

	@Override
	public Result update(CvLink cvLink) {
		
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Link Güncellendi");
	}

	@Override
	public Result delete(int id) {
		
		this.cvLinkDao.deleteById(id);
		return new SuccessResult("Link Silindi");
	}

	@Override
	public DataResult<CvLink> getById(int id) {
		
		return new SuccessDataResult<CvLink>(this.cvLinkDao.getById(id));
	}

	@Override
	public DataResult<List<CvLink>> getAll() {
		
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.findAll());
	}

	@Override
	public DataResult<List<CvLink>> getAllByJobseekerId(int id) {
		
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.getAllByJobseeker_id(id));
	}

}
