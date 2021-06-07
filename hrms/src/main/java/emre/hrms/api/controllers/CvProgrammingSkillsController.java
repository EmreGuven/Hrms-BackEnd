package emre.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import emre.hrms.business.abstracts.CvProgrammingSkillService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.CvProgrammingSkill;

@RestController
@RequestMapping("/api/programmingSkills")
public class CvProgrammingSkillsController {

	private CvProgrammingSkillService cvProgrammingSkillService;

	@Autowired
	public CvProgrammingSkillsController(CvProgrammingSkillService cvProgrammingSkillService) {
		super();
		this.cvProgrammingSkillService = cvProgrammingSkillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvProgrammingSkill cvProgrammingSkill) {
		
		return this.cvProgrammingSkillService.add(cvProgrammingSkill);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvProgrammingSkill cvProgrammingSkill) {
		
		return this.cvProgrammingSkillService.update(cvProgrammingSkill);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id ) {
		
		return this.cvProgrammingSkillService.delete(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvProgrammingSkill>> getAll() {
		
		return this.cvProgrammingSkillService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<CvProgrammingSkill> getById(@RequestParam("id") int id) {
		
		return this.cvProgrammingSkillService.getById(id);
	}
	
	@GetMapping("/getallbyjobseekerid")
	public DataResult<List<CvProgrammingSkill>> getAllByJobseekerId(@RequestParam int id) {
		
		return this.cvProgrammingSkillService.getAllByJobseekerId(id);
	}
	
	
}
