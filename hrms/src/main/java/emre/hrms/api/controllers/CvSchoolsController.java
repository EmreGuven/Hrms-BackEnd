package emre.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import emre.hrms.business.abstracts.CvSchoolService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.CvSchool;

@RestController
@RequestMapping("/api/schools")
public class CvSchoolsController {

	private CvSchoolService cvSchoolService;

	@Autowired
	public CvSchoolsController(CvSchoolService cvSchoolService) {
		super();
		this.cvSchoolService = cvSchoolService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvSchool cvSchool) {
		
		return this.cvSchoolService.add(cvSchool);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvSchool cvSchool) {
		
		return this.cvSchoolService.update(cvSchool);
	}
	
	@PostMapping("/delete")
	public Result add(@RequestParam int id) {
		
		return this.cvSchoolService.delete(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvSchool>> getAll() {
		
		return this.cvSchoolService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<CvSchool> getById(@RequestParam int id) {
		
		return this.cvSchoolService.getById(id);
	}
	
	@GetMapping("/getallbyjobseekerid")
	public DataResult<List<CvSchool>> getAllByJobseekerId(@RequestParam int id) {
		
		return this.cvSchoolService.getAllByJobseekerId(id);
	}
	
	@GetMapping("/getallbyjobseekeridorderbyendatdesc")
	public DataResult<List<CvSchool>> getAllByJobseekerIdOrderByEndAtDesc(@RequestParam int id) {
		
		return this.cvSchoolService.getAllByJobseekerIdOrderByEndAtDesc(id);
	}
}













