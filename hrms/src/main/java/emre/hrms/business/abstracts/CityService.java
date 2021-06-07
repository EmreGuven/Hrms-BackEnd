package emre.hrms.business.abstracts;

import java.util.List;

import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
}
