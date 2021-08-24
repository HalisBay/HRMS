package HRMSProject.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.Hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer> {

}
