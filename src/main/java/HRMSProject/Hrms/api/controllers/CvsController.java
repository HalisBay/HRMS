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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import HRMSProject.Hrms.business.abstracts.CvService;
import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.ErrorDataResult;
import HRMSProject.Hrms.entities.concretes.Cv;


@RestController
@RequestMapping("/api/cvs")
public class CvsController {
	
	private CvService cvService;

	@Autowired
	public CvsController(CvService cvService) {
		super();
		this.cvService = cvService;
	} 
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Cv cv ){	
		return ResponseEntity.ok(this.cvService.add(cv));
	}
	
	@PostMapping("/uploadImage")
	 public ResponseEntity<?> uploadImage(@RequestParam Integer cvId, @RequestParam String filePath) {
	     return ResponseEntity.ok(this.cvService.uploadImage(cvId, filePath));
	    }
	
	
	@GetMapping("/getAll")
	public DataResult<List<Cv>> getAll(){
		return this.cvService.getAll();
	}
	
	@GetMapping("/getAllByJobSeekerId")
	public DataResult<List<Cv>> getAllByJobSeekerId(@RequestParam int jobSeekerId){
		return this.cvService.getAllByJobSeeker_Id(jobSeekerId);
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
