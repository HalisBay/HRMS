package HRMSProject.Hrms.business.abstracts;

import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.entities.concretes.Employer;

public interface EmployerCheckService {
	
	Result checkEmployer(Employer employer);
}
