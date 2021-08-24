package HRMSProject.Hrms.core.adapters.abstracts;

import java.io.File;
import java.util.Map;

public interface CloudinaryService {
	
	public Map<String, Object> uploadImage(File file); 

}
