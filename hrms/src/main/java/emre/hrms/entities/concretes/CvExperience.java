package emre.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "cv_experiences")
@NoArgsConstructor
@AllArgsConstructor
public class CvExperience extends CommonComponent {

	@Column(name = "working_place")
	private String workingPlace;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "start_at")
	private LocalDate startAt;
	
	 @Column(name = "end_at", nullable = true)
	private LocalDate endAt;
	
	@ManyToOne()
	@JoinColumn(name = "jobseeker_id")
	private Jobseeker jobseeker;
}
