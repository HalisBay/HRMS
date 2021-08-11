package HRMSProject.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.Hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> getAllByIsActivatedTrue();
	List<JobAdvertisement> getAllByIsActivatedTrueOrderByCreatedTimeDesc();
    List<JobAdvertisement> getAllByEmployer_IdAndIsActivatedTrue(int employerId);

}
