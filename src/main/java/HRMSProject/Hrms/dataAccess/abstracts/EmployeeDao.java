package HRMSProject.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.Hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
