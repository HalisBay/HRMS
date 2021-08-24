package HRMSProject.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import HRMSProject.Hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "employees")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="employee_id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
public class Employee extends User {
	
	@NotNull
	@NotBlank
	@Column(name = "employee_name")
	private String name;
	
	@NotNull
	@NotBlank
	@Column(name = "employee_surname")
	private String surname;
	
	

}
