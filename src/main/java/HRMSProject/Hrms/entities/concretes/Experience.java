package HRMSProject.Hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Experience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "experience_id")
	private int id;
	
	@Column(name = "job_name")
	private String jobName;
	
	@Column(name = "job_position")
	private String jobPosition;
	
	@Column(name = "job_start_date")
	private LocalDate jobStartDate;
	
	@Column(name = "job_end_date")
	private LocalDate jobEndDate;
	
	
	@NotNull
	@NotBlank
	@Column(name = "working_status")
	private Boolean workingStatus;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;
}
