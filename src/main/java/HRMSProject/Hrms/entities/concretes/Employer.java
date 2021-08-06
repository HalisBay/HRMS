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
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="employer_id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
public class Employer  extends User{
	
	@NotNull
	@Column(name = "company_name")
	private String companyName;
	
	@NotNull
	@Column(name = "website")
	private String webSite;
	
	@NotNull
	@Column(name = "phone")
	private String phone;
	
}
