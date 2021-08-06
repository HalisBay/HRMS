package HRMSProject.Hrms.business.concretes;

import org.springframework.stereotype.Service;

import HRMSProject.Hrms.business.abstracts.EmailVerificationService;
import HRMSProject.Hrms.entities.abstracts.User;

@Service
public class EmailVerificationManager  implements EmailVerificationService{

	@Override
	public void sendEmail(User user) {
		System.out.println(user.getEmail() +" hesabınıza  mail adresinizin  başkası tarafından kullanılmadığından emin olmak için doğrulama kodu gönderdik :)");
	}

	@Override
	public void verifyEmail(User user) {
		System.out.println(user.getEmail()+" doğrulandı, sizi aramızda gördüğümüz için mutluyuz :) ");
	}

	@Override
	public boolean isVerifitaced(User user) {
		return true;
	}

}
