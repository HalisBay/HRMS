package HRMSProject.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.Hrms.business.abstracts.JobSeekerCheckService;
import HRMSProject.Hrms.business.abstracts.JobSeekerService;
import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.Hrms.core.utilities.results.SuccessResult;
import HRMSProject.Hrms.dataAccess.abstracts.JobSeekerDao;
import HRMSProject.Hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	private JobSeekerDao jobSeekerDao; 
	private JobSeekerCheckService checkService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, JobSeekerCheckService checkService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.checkService = checkService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş arayanlar listelendi");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if(!this.checkService.checkJobSeeker(jobSeeker).isSucces()) {
			return this.checkService.checkJobSeeker(jobSeeker);
		}
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Yeni iş arayan kullanıcı eklendi");
	}

}
