package HRMSProject.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.Hrms.business.abstracts.SchoolService;
import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.Hrms.core.utilities.results.SuccessResult;
import HRMSProject.Hrms.dataAccess.abstracts.SchoolDao;
import HRMSProject.Hrms.entities.concretes.School;
@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul bilgileri başarı ile eklendi");
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(), "Okul bilgileri başarı ile listelendi");
	}

	@Override
	public DataResult<List<School>> getAllByCv_IdOrderByGraduationYearDesc(int cvId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByCv_IdOrderByGraduationYearDesc(cvId),
				"Mezuniyet tarihe göre bilgisi başarı ile listelendi");
	}

}
