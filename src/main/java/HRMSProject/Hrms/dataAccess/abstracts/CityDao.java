package HRMSProject.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.Hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

}
