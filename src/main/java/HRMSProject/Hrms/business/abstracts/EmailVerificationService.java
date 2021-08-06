package HRMSProject.Hrms.business.abstracts;

import HRMSProject.Hrms.entities.abstracts.User;

public interface EmailVerificationService {
		
		void sendEmail(User user);
		
		void verifyEmail(User user);
		
		boolean isVerifitaced(User user);

}
