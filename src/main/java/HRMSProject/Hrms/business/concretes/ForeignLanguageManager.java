package HRMSProject.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.Hrms.business.abstracts.ForeignLanguageService;
import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.Hrms.core.utilities.results.SuccessResult;
import HRMSProject.Hrms.dataAccess.abstracts.ForeignLanguageDao;
import HRMSProject.Hrms.entities.concretes.ForeignLanguage;

@Service
public class ForeignLanguageManager  implements ForeignLanguageService{
	private ForeignLanguageDao foreignLanguageDao;
	
	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
	}

	@Override
	public Result add(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Yabancı dil başarı ile eklendi");
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll(), "Yabancı diller listelendi");
	}

}
