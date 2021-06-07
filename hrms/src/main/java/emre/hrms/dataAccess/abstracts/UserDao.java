package emre.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import emre.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findUserByEmail(String email);
	
	User getById(int id);
}
