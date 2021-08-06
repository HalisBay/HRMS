package HRMSProject.Hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import HRMSProject.Hrms.core.adapters.abstracts.MernisService;
import HRMSProject.Hrms.entities.concretes.JobSeeker;
@Service
public class MernisServiceAdapter implements MernisService {

	@Override
	public boolean isRealPerson(JobSeeker jobSeeker) {
		return true;
	}

}
