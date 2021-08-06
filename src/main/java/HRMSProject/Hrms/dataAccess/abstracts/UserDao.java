package HRMSProject.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.Hrms.entities.abstracts.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	boolean existsByEmail(String email);

}
