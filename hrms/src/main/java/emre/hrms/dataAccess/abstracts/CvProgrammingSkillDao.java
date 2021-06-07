package emre.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import emre.hrms.entities.concretes.CvProgrammingSkill;

public interface CvProgrammingSkillDao extends  JpaRepository<CvProgrammingSkill, Integer>{

	CvProgrammingSkill getById(int id);
	
	List<CvProgrammingSkill> getAllByJobseeker_id(int id);
}
