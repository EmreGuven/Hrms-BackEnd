package emre.hrms.business.abstracts;

import java.util.List;

import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.User;

public interface UserService {

	Result add(User user);
	
	DataResult<List<User>> getAll();
	
	DataResult<User> getUserByEmail(String email);
}
