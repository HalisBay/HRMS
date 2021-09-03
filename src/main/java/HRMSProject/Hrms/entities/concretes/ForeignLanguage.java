package HRMSProject.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
@Table(name = "languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ForeignLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private int id;
	
	@Column(name = "language_name")
	private String languageName;
	
	@Min(value = 1)
	@Max(value = 5)
	@Column(name = "language_level")
	private int languageLevel;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;
}
