package HRMSProject.Hrms.business.abstracts;

import java.util.List;

import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {

	Result add(ForeignLanguage foreignLanguage);
	
	DataResult<List<ForeignLanguage>> getAll();
}
