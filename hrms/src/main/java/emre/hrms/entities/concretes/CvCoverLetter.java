package emre.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "cv_cover_letters")
@NoArgsConstructor
public class CvCoverLetter extends CommonComponent {

	@Column(name = "content")
	private String content;
	
	@ManyToOne()
	@JoinColumn(name = "jobseeker_id")
	@JsonIgnore
	private Jobseeker jobseeker;
	
	public CvCoverLetter(String content, int jobseekerId) {
		
		super();
		this.content = content;
		this.jobseeker.setId(jobseekerId);
	}
}
