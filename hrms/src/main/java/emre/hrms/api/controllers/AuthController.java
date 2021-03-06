package emre.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emre.hrms.business.abstracts.AuthService;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.Employer;
import emre.hrms.entities.concretes.Jobseeker;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmployer(@RequestBody Employer employer, String confirmPassword)
	{
		return authService.registerEmployer(employer, confirmPassword);
	}
	
	@PostMapping("/registerJobSeeker")
	public Result registerJobSeeker(@RequestBody Jobseeker jobSeeker, String confirmPassword)
	{
		return authService.registerJobSeeker(jobSeeker, confirmPassword);
	}
}
