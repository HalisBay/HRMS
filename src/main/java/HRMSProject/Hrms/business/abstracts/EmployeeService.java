package HRMSProject.Hrms.business.abstracts;

import HRMSProject.Hrms.entities.concretes.Employer;

public interface EmployeeService {
	
	boolean validateEmployer(Employer employer);	
}
