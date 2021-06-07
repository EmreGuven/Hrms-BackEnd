package emre.hrms.core.utilities.helpers;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import emre.hrms.core.utilities.results.DataResult;

public interface ImageHelperService {

	
	@SuppressWarnings("rawtypes")
	DataResult<Map> upload(MultipartFile imageFile);
}
