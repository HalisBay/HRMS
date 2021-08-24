package HRMSProject.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.Hrms.entities.concretes.Skill;

public interface SkillDao  extends JpaRepository<Skill, Integer>{

}
