package HRMSProject.Hrms.business.abstracts;

import java.util.List;

import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.entities.concretes.Experience;

public interface ExperienceService {

	Result add(Experience experience);
	
	DataResult<List<Experience>> getAll();
	DataResult<List<Experience>> getAllByCv_IdOrderByJobEndDateDesc(int cvId);
}
