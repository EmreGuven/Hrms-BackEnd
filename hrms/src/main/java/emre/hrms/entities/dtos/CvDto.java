package emre.hrms.entities.dtos;

import java.util.List;

import emre.hrms.entities.concretes.CvExperience;
import emre.hrms.entities.concretes.CvForeignLanguage;
import emre.hrms.entities.concretes.CvImages;
import emre.hrms.entities.concretes.CvLink;
import emre.hrms.entities.concretes.CvProgrammingSkill;
import emre.hrms.entities.concretes.CvSchool;
import emre.hrms.entities.concretes.Jobseeker;

public class CvDto {

	public Jobseeker jobSeeker;
	public CvImages image;
	public List<CvSchool> schools;
	public List<CvExperience> experiences;
	public List<CvForeignLanguage> languages;
	public List<CvLink> links;
	public List<CvProgrammingSkill> programmingSkills;
}
