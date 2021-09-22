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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import HRMSProject.Hrms.business.abstracts.ExperienceService;
import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.ErrorDataResult;
import HRMSProject.Hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin
public class ExperiencesController {
	
	private ExperienceService experienceService;
	
	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Experience experience){
		return ResponseEntity.ok(this.experienceService.add(experience));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Experience>> getAll(){
		
		return this.experienceService.getAll();
	}
	
	@GetMapping("getAllByCv_IdOrderByJobEndDateDesc")
	public DataResult<List<Experience>> getAllByCv_IdOrderByJobEndDateDesc(int cvId){
		return this.experienceService.getAllByCv_IdOrderByJobEndDateDesc(cvId);
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
