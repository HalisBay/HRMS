package HRMSProject.Hrms.business.abstracts;

import java.util.List;

import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	Result addJobPosition(JobPosition jobPosition);
	
	DataResult<List<JobPosition>> getAll();

}
