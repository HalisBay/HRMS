package HRMSProject.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "skills")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Skill {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "skills_id")
	private int id;
	
	@Column(name = "about_skills")
	private String aboutSkills;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name ="cv_id")
	private Cv cv;
	
	
}
