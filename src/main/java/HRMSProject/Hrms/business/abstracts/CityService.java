package HRMSProject.Hrms.business.abstracts;

import java.util.List;

import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.entities.concretes.City;

public interface CityService {
	
	DataResult<List<City>> getAll();

}
