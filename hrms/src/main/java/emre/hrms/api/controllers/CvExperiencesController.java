package emre.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import emre.hrms.business.abstracts.CvExperienceService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.CvExperience;

@RestController
@RequestMapping("/api/experiences")
public class CvExperiencesController {

	private CvExperienceService cvExperienceService;

	@Autowired
	public CvExperiencesController(CvExperienceService cvExperienceService) {
		super();
		this.cvExperienceService = cvExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvExperience cvExperience){
		return this.cvExperienceService.add(cvExperience);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvExperience cvExperience){
		return this.cvExperienceService.update(cvExperience);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.cvExperienceService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CvExperience> getById(@RequestParam int id){
		return this.cvExperienceService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvExperience>> getAll(){
		return this.cvExperienceService.getAll();
	}
	
	@GetMapping("/getallbyjobseekeridorderbyendatdesc")
	public DataResult<List<CvExperience>> getAllByJobseekerIdOrderByEndAtDesc(@RequestParam("id") int id){
		return this.cvExperienceService.getAllByJobseekerIdOrderByEndAtDesc(id);
	}
	
	@GetMapping("/getallbyjobseekerid")
	public DataResult<List<CvExperience>> getAllByJobseekerId(@RequestParam int id){
		return this.cvExperienceService.getAllByJobseekerId(id);
	}
}
