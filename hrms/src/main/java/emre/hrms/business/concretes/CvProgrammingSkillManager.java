package emre.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emre.hrms.business.abstracts.CvProgrammingSkillService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.core.utilities.results.SuccessDataResult;
import emre.hrms.core.utilities.results.SuccessResult;
import emre.hrms.dataAccess.abstracts.CvProgrammingSkillDao;
import emre.hrms.entities.concretes.CvProgrammingSkill;

@Service
public class CvProgrammingSkillManager implements CvProgrammingSkillService {

	private CvProgrammingSkillDao cvProgrammingSkillDao;
	
	@Autowired
	public CvProgrammingSkillManager(CvProgrammingSkillDao cvProgrammingSkillDao) {
		super();
		this.cvProgrammingSkillDao = cvProgrammingSkillDao;
	}

	@Override
	public Result add(CvProgrammingSkill cvProgrammingSkill) {
		
		this.cvProgrammingSkillDao.save(cvProgrammingSkill);
		return new SuccessResult("Programlama Beceri Bilgisi Eklendi");
	}

	@Override
	public Result update(CvProgrammingSkill cvProgrammingSkill) {
		
		this.cvProgrammingSkillDao.save(cvProgrammingSkill);
		return new SuccessResult("Programlama Beceri Bilgisi Güncellendi");
	}

	@Override
	public Result delete(int id) {
		
		this.cvProgrammingSkillDao.deleteById(id);
		return new SuccessResult("Programlama Beceri Bilgisi Silindi");
		}

	@Override
	public DataResult<CvProgrammingSkill> getById(int id) {
		
		return new SuccessDataResult<CvProgrammingSkill>(this.cvProgrammingSkillDao.getById(id));
	}

	@Override
	public DataResult<List<CvProgrammingSkill>> getAll() {
		
		return new SuccessDataResult<List<CvProgrammingSkill>>(this.cvProgrammingSkillDao.findAll());
	}

	@Override
	public DataResult<List<CvProgrammingSkill>> getAllByJobseekerId(int id) {
		
		return new SuccessDataResult<List<CvProgrammingSkill>>(this.cvProgrammingSkillDao.getAllByJobseeker_id(id));
	}

}
