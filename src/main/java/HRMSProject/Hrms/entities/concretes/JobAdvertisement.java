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

import org.hibernate.annotations.CreationTimestamp;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_advertisement_id")
	private int id;
	
	@NotNull
	@Column(name = "job_advertisement_description")
	private String description;
	
	
	@Column(name = "job_advertisement_min_salary")
	private int minSalary;
	
	
	@Column(name = "job_advertisement_max_salary")
	private int maxSalary;
	
	@NotNull
	@Column(name = "job_advertisement_open_positions")
	private int openPosition;
	
	@NotNull
	@Column(name = "job_advertisement_latest_apply_time")
	private LocalDate latestApplyTime;
	
	@NotNull
	@Column(name = "is_job_advertisement_activated")
	private boolean isActivated;
	
	@NotNull
	@CreationTimestamp
	@Column(name = "job_advertisement_create_time")
	private LocalDate createdTime;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id")
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	
	

}
