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
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="employer_id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer  extends User{
	
	@NotNull
	@NotBlank
	@Column(name = "company_name")
	private String companyName;
	
	@NotNull
	@NotBlank
	@Column(name = "website")
	private String webSite;
	
	@NotNull
	@NotBlank
	@Column(name = "phone")
	private String phone;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	
}
