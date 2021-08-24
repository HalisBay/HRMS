package HRMSProject.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.Hrms.entities.concretes.Cv;

public interface CvDao  extends JpaRepository<Cv, Integer>{

	List<Cv> getAllByJobSeeker_Id(int jobSeekerId);
}
