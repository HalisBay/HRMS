package HRMSProject.Hrms.business.abstracts;

import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.entities.concretes.JobSeeker;


public interface JobSeekerCheckService {

	Result checkJobSeeker(JobSeeker jobSeeker);
}
