package emre.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import emre.hrms.business.abstracts.CvCoverLetterService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.CvCoverLetter;

@RestController
@RequestMapping("/api/coverletters")
public class CvCoverLettersController {

	private CvCoverLetterService coverLetterService;

	@Autowired
	public CvCoverLettersController(CvCoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvCoverLetter coverLetter){
		return this.coverLetterService.add(coverLetter);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvCoverLetter coverLetter){
		return this.coverLetterService.update(coverLetter);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.coverLetterService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CvCoverLetter> getById(@RequestParam("id") int id){
		return this.coverLetterService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvCoverLetter>> getAll(){
		return this.coverLetterService.getAll();
	}
}
