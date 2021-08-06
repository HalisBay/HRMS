package HRMSProject.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.Hrms.business.abstracts.EmailVerificationService;
import HRMSProject.Hrms.business.abstracts.EmployeeService;
import HRMSProject.Hrms.business.abstracts.EmployerCheckService;
import HRMSProject.Hrms.core.utilities.results.ErrorResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.core.utilities.results.SuccessResult;
import HRMSProject.Hrms.dataAccess.abstracts.UserDao;
import HRMSProject.Hrms.entities.concretes.Employer;

@Service
public class EmployerCheckManager  implements EmployerCheckService{
	private UserDao userDao;
	private EmailVerificationService emailVerificationService;
	private EmployeeService employeeService;
	
	@Autowired
	public EmployerCheckManager(UserDao userDao,
			EmailVerificationService emailVerificationService, EmployeeService employeeService) {
		this.userDao = userDao;
		this.emailVerificationService = emailVerificationService;
		this.employeeService = employeeService;
	}


	@Override
	public Result checkEmployer(Employer employer) {
		String[] splitMail = employer.getEmail().split("@");
		
		if(employer.getPhone().isEmpty() || employer.getEmail().isEmpty() || employer.getWebSite().isEmpty() ||
				employer.getCompanyName().isEmpty() || employer.getPassword().isEmpty() || employer.getVerifyPassword().isEmpty()) {
			return new ErrorResult("bütün alanlar doldurulmak zorundadır.");
			
		}
		
		else if(!splitMail[1].equals(employer.getWebSite())) {
			return new ErrorResult("website adınız ile mail adınızla eşleşmemekte. örnek: asd.com ve örnek@asd.com gibi olmalı..");
		}
		else if (!this.emailVerificationService.isVerifitaced(employer)) {
			return new ErrorResult("Email adresi doğrulanamadı");
		}
		else if(!employer.getPassword().equals(employer.getVerifyPassword())){
			return new ErrorResult("parolalar eşleşmemekte");
		}
		else if(this.userDao.existsByEmail(employer.getEmail())) {
			return new ErrorResult("Bu email adresi daha önce kullanılmıştır. Aynı email adresi kullanılarak tekrar kayıt yapılamaz");
		}
		else if (!this.employeeService.validateEmployer(employer)) {
			return new ErrorResult(" Sistem personeli tarafından kabul görülmediniz.");
		}
		else {
			this.emailVerificationService.sendEmail(employer);
			this.emailVerificationService.verifyEmail(employer);
			System.out.println("Bütün bilgileriniz doğrulandı");
			return new SuccessResult();
		}
		
	}
}
