package HRMSProject.Hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import HRMSProject.Hrms.business.abstracts.JobAdvertisementService;
import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.ErrorDataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add ( @Valid @RequestBody JobAdvertisement jobAdvertisement) {
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement)) ;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		
		return this.jobAdvertisementService.getAll();
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
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Hata!, validationErrors");
        return errors;
    }

}
