package HRMSProject.Hrms.core.adapters.abstracts;

import HRMSProject.Hrms.entities.concretes.JobSeeker;

public interface MernisService {
	boolean isRealPerson(JobSeeker jobSeeker);

}
