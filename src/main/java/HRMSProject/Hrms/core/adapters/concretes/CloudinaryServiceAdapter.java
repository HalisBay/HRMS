package HRMSProject.Hrms.core.adapters.concretes;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import HRMSProject.Hrms.core.adapters.abstracts.CloudinaryService;

@Service
public class CloudinaryServiceAdapter implements CloudinaryService{
	
	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryServiceAdapter() {
		this.cloudinary = new Cloudinary("cloudinary://477732626538194:SaPb-P8bUdQMS9B0yeO7cMD9LpI@glass123");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> uploadImage(File file) {
		
		try {
			
			Map params = ObjectUtils.asMap(
					"folder", null,
                    "public_id", null,
                    "overwrite", true,
                    "notification_url", null,
                    "resource_type", "image"
		
					);
			
			Map<String, Object> upload = cloudinary.uploader().upload(file, params);
			return upload;
					
		}
		
		catch (Exception e) {
			
			return null;
		}
			
	}

	
	
	
	

}
