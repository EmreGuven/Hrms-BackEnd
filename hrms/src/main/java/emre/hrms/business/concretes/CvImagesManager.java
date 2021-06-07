package emre.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import emre.hrms.business.abstracts.CvImagesService;
import emre.hrms.core.utilities.helpers.ImageHelperService;
import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.Result;
import emre.hrms.core.utilities.results.SuccessDataResult;
import emre.hrms.core.utilities.results.SuccessResult;
import emre.hrms.dataAccess.abstracts.CvImagesDao;
import emre.hrms.entities.concretes.CvImages;

@Service
public class CvImagesManager implements CvImagesService {

	private CvImagesDao cvImagesDao;
	private ImageHelperService imageHelperService;
	
	public CvImagesManager(CvImagesDao cvImagesDao, ImageHelperService imageHelperService) {
		super();
		this.cvImagesDao = cvImagesDao;
		this.imageHelperService = imageHelperService;
	}

	@Override
	public Result add(CvImages cvImages, MultipartFile imageFile) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> uploadImage = this.imageHelperService.upload(imageFile).getData();
		cvImages.setUrl(uploadImage.get("url"));
		this.cvImagesDao.save(cvImages);
		return new SuccessResult("Resim Eklendi");
	}

	@Override
	public Result update(CvImages cvImages) {
		
		this.cvImagesDao.save(cvImages);
		return new SuccessResult("Resim Güncellendi");
	}

	@Override
	public Result delete(int id) {
		
		this.cvImagesDao.deleteById(id);
		return new SuccessResult("Resim Silindi");
	}

	@Override
	public DataResult<CvImages> getById(int id) {
		
		return new SuccessDataResult<CvImages>(this.cvImagesDao.getById(id));
	}

	@Override
	public DataResult<CvImages> getByJobseekerId(int id) {
		
		return new SuccessDataResult<CvImages>(this.cvImagesDao.getByJobseeker_id(id));
	}

	@Override
	public DataResult<List<CvImages>> getAll() {
		
		return new SuccessDataResult<List<CvImages>>(this.cvImagesDao.findAll());
	}

}
