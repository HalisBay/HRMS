package HRMSProject.Hrms.business.abstracts;

import java.util.List;

import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {

	DataResult<List<JobSeeker>> getAll();
	
	Result add(JobSeeker jobSeeker);
}
