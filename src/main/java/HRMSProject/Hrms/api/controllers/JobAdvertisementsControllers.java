package HRMSProject.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HRMSProject.Hrms.business.abstracts.JobAdvertisementService;
import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementsControllers {
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsControllers(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add ( @RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	

	@GetMapping("/findAllByIsActivedTrue")
	public DataResult<List<JobAdvertisement>> getAllByIsActivatedTrue() {
		return this.jobAdvertisementService.getAllByIsActivatedTrue();
	}
	
	@GetMapping("/getAllByIsActivatedTrueOrderByCreatedTimeDesc")
	public DataResult<List<JobAdvertisement>> getAllByIsActivatedTrueOrderByCreatedTimeDesc(){
		return this.jobAdvertisementService.getAllByIsActivatedTrueOrderByCreatedTimeDesc();
	}
	
	@GetMapping("/getAllByEmployerIdAndIsActivatedTrue")
	public DataResult<List<JobAdvertisement>> getAllByEmployer_IdAndIsActivatedTrue(@RequestParam int employerId ){
		return this.jobAdvertisementService.getAllByEmployer_IdAndIsActivatedTrue(employerId);
	}
	
	@PutMapping("/setActivate")
	public Result setActivate(@RequestParam int jobAdvertisementId, @RequestParam boolean result) {
		return this.jobAdvertisementService.setActivate(jobAdvertisementId, result);
	}

}
