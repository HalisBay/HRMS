package HRMSProject.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.Hrms.business.abstracts.JobAdvertisementService;
import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.Hrms.core.utilities.results.SuccessResult;
import HRMSProject.Hrms.dataAccess.abstracts.JobAdvertisementDao;
import HRMSProject.Hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"İş ilanları listelendi");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı sisteme eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActivatedTrue() {
		 return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByIsActivatedTrue(), "Aktif iş ilanları listelendi");
	
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActivatedTrueOrderByCreatedTimeDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByIsActivatedTrueOrderByCreatedTimeDesc(), "Aktif iş ilanları tarihe göre listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByEmployer_IdAndIsActivatedTrue(int employerId) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByEmployer_IdAndIsActivatedTrue(employerId),"şirketin iş ilanları listelendi");
	}

	@Override
	public Result setActivate(int jobAdvertisementId, boolean result) {
		JobAdvertisement jobAdvertisement;
		jobAdvertisement = this.jobAdvertisementDao.findById(jobAdvertisementId).get();
		jobAdvertisement.setActivated(result);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult(" İlanın aktiflik durumu : " + result);
		
	}

}
