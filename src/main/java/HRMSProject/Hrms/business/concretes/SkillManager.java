package HRMSProject.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.Hrms.business.abstracts.SkillService;
import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.Hrms.core.utilities.results.SuccessResult;
import HRMSProject.Hrms.dataAccess.abstracts.SkillDao;
import HRMSProject.Hrms.entities.concretes.Skill;

@Service
public class SkillManager  implements SkillService{
	
	private SkillDao skillDao;
	
	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public Result add(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("Beceri başarı ile eklendi");
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll(), "Beceriler başarı ile listelendi");
	}

}
