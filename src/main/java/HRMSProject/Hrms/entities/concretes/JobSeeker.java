package HRMSProject.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.sun.istack.NotNull;
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
@EqualsAndHashCode(callSuper = false)
public class JobSeeker extends User {
	
	@NotNull
	@Column(name = "job_seeker_name")
	private String name;
	
	@NotNull
	@Column(name = "job_seeker_surname")
	private String surname;
	
	@NotNull
	@Column(name = "job_seeker_nationality_id")
	private String nationalId;
	
	@NotNull
	@Column(name = "job_seeker_birth_year")
	private String  birthYear;

}
