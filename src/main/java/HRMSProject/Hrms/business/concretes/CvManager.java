package HRMSProject.Hrms.business.concretes;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.Hrms.business.abstracts.CvService;
import HRMSProject.Hrms.core.adapters.concretes.CloudinaryServiceAdapter;
import HRMSProject.Hrms.core.utilities.results.DataResult;
import HRMSProject.Hrms.core.utilities.results.ErrorDataResult;
import HRMSProject.Hrms.core.utilities.results.Result;
import HRMSProject.Hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.Hrms.core.utilities.results.SuccessResult;
import HRMSProject.Hrms.dataAccess.abstracts.CvDao;
import HRMSProject.Hrms.entities.concretes.Cv;

@Service
public class CvManager implements CvService  {
	 private CvDao cvDao;
	 private CloudinaryServiceAdapter cloudinaryServiceAdapter;
	
	 
	 @Autowired
	public CvManager(CvDao cvDao, CloudinaryServiceAdapter cloudinaryServiceAdapter) {
		this.cvDao = cvDao;
		this.cloudinaryServiceAdapter = cloudinaryServiceAdapter;
		
	}
	 
	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Cv başarı ile eklendi");
	}
	
	@Override
	public Result uploadImage(int cvId, String filePath) {
		   File file = new File(filePath);
	        Object object = this.cloudinaryServiceAdapter.uploadImage(file).get("secure_url");
	        
	        if ((object == null)) {
	            return new ErrorDataResult<String>(null, "Resim bulunamadı");

	        } 
	        
	        else if (!this.cvDao.existsById(cvId)) {
	            return new ErrorDataResult<String>(null, "Verdiğiniz id ye uygun bir cv bulunamadı");
	        } 
	        
	        else  {
	            String secure_url = object.toString();
	            Cv cv = this.cvDao.findById(cvId).get();
	            cv.setImage(secure_url);
	            this.cvDao.save(cv);
	            return new SuccessDataResult<String>(secure_url, "resim başarı ile yüklendi.");
	        }
	     
	}
	

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "Cvler başarı ile listelendi");
	}

	@Override
	public DataResult<List<Cv>> getAllByJobSeeker_Id(int jobSeekerId) {
		 return new SuccessDataResult<List<Cv>>(this.cvDao.getAllByJobSeeker_Id(jobSeekerId),"Cvler iş arayan kullanılara göre başarı ile listelendi");
	}

	




	

}
