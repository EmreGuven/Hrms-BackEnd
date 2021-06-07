package emre.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.entities.concretes.CvImages;

public interface CvImagesService {

	Result add(CvImages cvImages, MultipartFile imageFile);
	
	Result update(CvImages cvImages);
	
	Result delete(int id);
	
	DataResult<CvImages> getById(int id);
	
	DataResult<CvImages> getByJobseekerId(int id);
	
	DataResult<List<CvImages>> getAll();
	
	
}
