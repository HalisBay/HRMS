package HRMSProject.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
public class Cv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "github_link")
	private String gitLink;
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@Column(name = "image")
	private String image;
	
	@ManyToOne
	@JoinColumn(name ="job_seeker_id")
	private JobSeeker jobSeeker;
	
	
	@OneToMany(mappedBy = "cv")
	private List<School> schools;
	

	@OneToMany(mappedBy = "cv")
	private List<Experience> experiences;
	

	@OneToMany(mappedBy = "cv")
	private List<ForeignLanguage>  foreignLanguages;
	

	@OneToMany(mappedBy = "cv")
	private List<Skill> skills;
	

}
