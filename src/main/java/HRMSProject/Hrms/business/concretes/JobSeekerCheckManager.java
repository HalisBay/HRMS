package HRMSProject.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.Hrms.business.abstracts.EmailVerificationService;
import HRMSProject.Hrms.business.abstracts.JobSeekerCheckService;
import HRMSProject.Hrms.core.adapters.abstracts.MernisService;
import HRMSProject.Hrms.core.utilities.results.ErrorResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.core.utilities.results.SuccessResult;
import HRMSProject.Hrms.dataAccess.abstracts.JobSeekerDao;
import HRMSProject.Hrms.dataAccess.abstracts.UserDao;
import HRMSProject.Hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerCheckManager implements JobSeekerCheckService {
	
	private  UserDao userDao;
	private  JobSeekerDao jobSeekerDao;
	private  EmailVerificationService emailVerificationService;
	private  MernisService mernisService;

	@Autowired
	public JobSeekerCheckManager(UserDao userDao, JobSeekerDao jobSeekerDao,
			EmailVerificationService emailVerificationService, MernisService mernisService) {
		super();
		this.userDao = userDao;
		this.jobSeekerDao = jobSeekerDao;
		this.emailVerificationService = emailVerificationService;
		this.mernisService = mernisService;
	}


	@Override
	public Result checkJobSeeker(JobSeeker jobSeeker) {
		if(jobSeeker.getBirthYear().isEmpty()  || jobSeeker.getEmail().isEmpty() || jobSeeker.getName().isEmpty() || 
				jobSeeker.getNationalId().isEmpty() || jobSeeker.getPassword().isEmpty() || jobSeeker.getVerifyPassword().isEmpty()) {
			return new ErrorResult("bütün alanlar doldurulmak zorundadır.");
			
		}
		else if(this.userDao.existsByEmail(jobSeeker.getEmail())) {
			return new ErrorResult("Bu email adresi kullanışmıştır. Kullanılan email ile tekrar kayıt gerçekleşmez.");
		}
		else if(this.jobSeekerDao.existsByNationalId(jobSeeker.getNationalId())) {
			return new ErrorResult("Bu kimlik numarası kullanılmıştır. Aynı kimlik numarası ile tekrar kayıt yapılamaz.");
		}
		else if(!jobSeeker.getPassword().equals(jobSeeker.getVerifyPassword())) {
			return new ErrorResult("parolalar eşleşmemekte");
		}
		
		else if(!this.mernisService.isRealPerson(jobSeeker)) {
			return new ErrorResult("Bilgilerinizin doğru olduğuna emin olun bilgileriniz doğrulanamadı.");
		}
		else if (!this.emailVerificationService.isVerifitaced(jobSeeker)) {
			return new ErrorResult("Email adresi doğrulanamadı");
		}
		else {
			this.emailVerificationService.sendEmail(jobSeeker);
			this.emailVerificationService.verifyEmail(jobSeeker);
			System.out.println("Kimlik bilgileriniz doğrulandı.");
			return new SuccessResult();
		}
		
	}
	

}
