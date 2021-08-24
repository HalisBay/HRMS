package HRMSProject.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import HRMSProject.Hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seekers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="job_seeker_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvs"})
@EqualsAndHashCode(callSuper = false)
public class JobSeeker extends User {
	
	@NotNull
	@NotBlank
	@Column(name = "job_seeker_name")
	private String name;
	
	@NotNull
	@NotBlank
	@Column(name = "job_seeker_surname")
	private String surname;
	
	@NotNull
	@NotBlank
	@Column(name = "job_seeker_nationality_id")
	private String nationalId;
	
	@NotNull
	@NotBlank
	@Column(name = "job_seeker_birth_year")
	private String  birthYear;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Cv> cvs;

}
