package HRMSProject.Hrms.business.abstracts;

import java.util.List;

import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.entities.concretes.Employer;

public interface EmployerService {
	
	Result add(Employer employer);
	
	DataResult<List<Employer>> getAll();
}
