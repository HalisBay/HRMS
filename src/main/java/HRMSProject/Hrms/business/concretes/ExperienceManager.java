package HRMSProject.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.Hrms.business.abstracts.ExperienceService;
import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.Hrms.core.utilities.results.SuccessResult;
import HRMSProject.Hrms.dataAccess.abstracts.ExperienceDao;
import HRMSProject.Hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {
	
	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("İş Deneyimi başarı ile eklendi");
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(), "İş deneyimleri başarı ile  listelendi");
	}

	@Override
	public DataResult<List<Experience>> getAllByCv_IdOrderByJobEndDateDesc(int cvId) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getAllByCv_IdOrderByJobEndDateDesc(cvId), "İş deneyimi tarihe göre listelendi");
	}

}
