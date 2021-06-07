package emre.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class User extends CommonComponent {
	
	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	

}
