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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class School {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "school_id")
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name = "school_name")
	private String schoolName;
	
	@NotNull
	@NotBlank
	@Column(name = "education_department")
	private String educationDepartment;
	
	@NotNull
	@NotBlank
	@Column(name = "graduation_status")
	private Boolean graduationStatus;
	
	@NotNull
	@NotBlank
	@Column(name = "graduation_year")
	private LocalDate graduationYear;
	
	@Column(name = "school_start_date")
	private LocalDate schoolStartDate;
	
	@Column(name = "school_end_date")
	private LocalDate schoolEndDate;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;

}
