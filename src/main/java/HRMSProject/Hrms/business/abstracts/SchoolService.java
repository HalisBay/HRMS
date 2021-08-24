package HRMSProject.Hrms.business.abstracts;

import java.util.List;

import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.entities.concretes.School;

public interface SchoolService {
	
	Result add(School school);
	
	DataResult<List<School>> getAll();
	DataResult<List<School>> getAllByCv_IdOrderByGraduationYearDesc(int cvId);
}
