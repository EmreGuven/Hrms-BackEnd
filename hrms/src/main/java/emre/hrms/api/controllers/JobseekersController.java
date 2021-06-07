package emre.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import emre.hrms.business.abstracts.JobseekerService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.Jobseeker;
import emre.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/jobseekers")
public class JobseekersController {

	private JobseekerService jobseekerService;

	@Autowired
	public JobseekersController(JobseekerService jobseekerService) {
		super();
		this.jobseekerService = jobseekerService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Jobseeker jobseeker)
	{
		return this.jobseekerService.add(jobseeker);
	}
	
	@GetMapping("/getcvbyid")
	public DataResult<CvDto> getCvById(@RequestParam int id) {
		
		return this.jobseekerService.getCvById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Jobseeker>> getAll()
	{
		return this.jobseekerService.getAll();
	}
}
