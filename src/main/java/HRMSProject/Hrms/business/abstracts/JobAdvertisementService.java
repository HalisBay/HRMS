package HRMSProject.Hrms.business.abstracts;

import java.util.List;

import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult <List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult <List<JobAdvertisement>>  getAllByIsActivatedTrue();
	DataResult <List<JobAdvertisement>> getAllByIsActivatedTrueOrderByCreatedTimeDesc();
	DataResult <List<JobAdvertisement>> getAllByEmployer_IdAndIsActivatedTrue(int employerId);
	Result setActivate(int jobAdvertisementId,boolean result );

}
