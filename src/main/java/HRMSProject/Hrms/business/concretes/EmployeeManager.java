package HRMSProject.Hrms.business.concretes;

import org.springframework.stereotype.Service;

import HRMSProject.Hrms.business.abstracts.EmployeeService;
import HRMSProject.Hrms.entities.concretes.Employer;
@Service
public class EmployeeManager implements EmployeeService {

	@Override
	public boolean validateEmployer(Employer employer) {
		System.out.println("Emailinizin, şirket emaili olduğu sistem personeli tarafından doğrulandı");
		return true;
	}


}
