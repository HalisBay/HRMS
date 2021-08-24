package HRMSProject.Hrms.business.abstracts;

import java.util.List;

import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.entities.concretes.Skill;

public interface SkillService {
	
	Result add(Skill skill);
	
	DataResult<List<Skill>> getAll();

}
