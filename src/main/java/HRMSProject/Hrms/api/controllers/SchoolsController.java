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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import HRMSProject.Hrms.business.abstracts.SchoolService;
import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.ErrorDataResult;
import HRMSProject.Hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
	
	private SchoolService schoolService;
	
	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody School school){
		 
		return ResponseEntity.ok(this.schoolService.add(school));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	}
	
	@GetMapping("/getAllByCv_IdOrderByGraduationYearDesc")
	public DataResult<List<School>> getAllByCv_IdOrderByGraduationYearDesc(int cvId){
		return this.schoolService.getAllByCv_IdOrderByGraduationYearDesc(cvId);
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
