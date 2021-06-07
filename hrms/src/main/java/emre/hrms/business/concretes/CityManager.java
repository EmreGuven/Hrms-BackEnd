package emre.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emre.hrms.business.abstracts.CityService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.SuccessDataResult;
import emre.hrms.dataAccess.abstracts.CityDao;
import emre.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

}
