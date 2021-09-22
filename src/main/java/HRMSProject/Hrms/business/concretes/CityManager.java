package HRMSProject.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.Hrms.business.abstracts.CityService;
import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.Hrms.dataAccess.abstracts.CityDao;
import HRMSProject.Hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Şehirler başarı ile listelendi");
	}

}
