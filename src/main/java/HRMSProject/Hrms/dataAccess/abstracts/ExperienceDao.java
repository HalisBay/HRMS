package HRMSProject.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.Hrms.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer>  {
	
	List<Experience> getAllByCv_IdOrderByJobEndDateDesc(int cvId);

}
