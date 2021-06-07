package emre.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import emre.hrms.business.abstracts.CvImagesService;
import emre.hrms.business.abstracts.JobseekerService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.CvImages;
import emre.hrms.entities.concretes.Jobseeker;

@RestController
@RequestMapping("/api/images")
public class ImagesController {

	private CvImagesService cvImageService;
	private JobseekerService jobseekerService;
	
	@Autowired
	public ImagesController(CvImagesService cvImageService, JobseekerService jobseekerService) {
		super();
		this.cvImageService = cvImageService;
		this.jobseekerService = jobseekerService;
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile) {
		
		Jobseeker jobSeeker = this.jobseekerService.getById(id).getData();
		CvImages cvImages = new CvImages();
		cvImages.setJobseeker(jobSeeker);
		return this.cvImageService.add(cvImages, imageFile);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvImages cvImages) {
		
		return this.cvImageService.update(cvImages);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		
		return this.cvImageService.delete(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvImages>> getAll() {
		
		return this.cvImageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<CvImages> getById(@RequestParam("id") int id) {
		
		return this.cvImageService.getById(id);
	}
	
	@GetMapping("/getallbyjobseekerid")
	public DataResult<CvImages> getAllByJobseekerId(@RequestParam int id) {
		
		return this.cvImageService.getByJobseekerId(id);
	}
}




