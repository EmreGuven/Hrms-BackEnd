package emre.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "jobseekers")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
public class Jobseeker extends User{

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "national_id" )
	private String nationalId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified=false;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<CvSchool> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<CvCoverLetter> coverLetters;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<CvExperience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<CvForeignLanguage> languages;
	
	@Nullable
	@JsonIgnore
	@OneToOne(mappedBy = "jobseeker",optional=false, fetch = FetchType.LAZY)
	private CvImages image;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<CvLink> links;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<CvProgrammingSkill> programmingSkills;
	
	
}
