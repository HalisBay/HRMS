package HRMSProject.Hrms.business.abstracts;

import java.util.List;

import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.entities.concretes.Cv;

public interface CvService {
	
	Result add(Cv cv);
	Result uploadImage (int cvId, String filePath);
	
	DataResult<List<Cv>> getAll();
	DataResult<List<Cv>> getAllByJobSeeker_Id(int jobSeekerId);
	

}
