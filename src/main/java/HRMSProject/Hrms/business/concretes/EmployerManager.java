package HRMSProject.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.Hrms.business.abstracts.EmployerCheckService;
import HRMSProject.Hrms.business.abstracts.EmployerService;
import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.Hrms.core.utilities.results.SuccessResult;
import HRMSProject.Hrms.dataAccess.abstracts.EmployerDao;
import HRMSProject.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private EmployerCheckService employerCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmployerCheckService checkService) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService = checkService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"iş Verenler Listelendi.");
		
	}

	@Override
	public Result add(Employer employer) {
		
		if(!this.employerCheckService.checkEmployer(employer).isSucces()) {
			return this.employerCheckService.checkEmployer(employer);
		}
	    employerDao.save(employer);
		return new SuccessResult("Yeni iş veren eklendi");
	}

	
}
