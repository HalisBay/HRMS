package HRMSProject.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.Hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {
	
	List<School> getAllByCv_IdOrderByGraduationYearDesc(int cvId);

}
