package emre.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import emre.hrms.business.abstracts.JobAdvertService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadvert")
public class JobAdvertController {
	
	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@GetMapping("/getallopenjobadvertlist")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList() {
		
		return this.jobAdvertService.getAllOpenJobAdvertList();
	}
	
	@GetMapping("/getallbyorderbypublishedatasc")
	public DataResult<List<JobAdvert>> getAllByOrderByPublishedAtAsc() {
		
		return this.jobAdvertService.getAllByOrderByPublishedAtAsc();
	}
	
	@GetMapping("/")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(@RequestParam int id) {
		
		return this.jobAdvertService.getAllOpenJobAdvertByEmployer(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvert> getById(int id) {
		
		return this.jobAdvertService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll() {
		
		return this.jobAdvertService.getAll();
	}
	
	@PostMapping("/activetopassive")
	public Result activeToPassive(int id) {
		
		return this.jobAdvertService.activeToPassive(id);
	}
	
	
}

















