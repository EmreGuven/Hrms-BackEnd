package emre.hrms.core.utilities.helpers;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import emre.hrms.core.utilities.results.DataResult;
import emre.hrms.core.utilities.results.ErrorDataResult;
import emre.hrms.core.utilities.results.SuccessDataResult;


@Service
public class ImageHelperManager implements ImageHelperService{

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<Map> upload(MultipartFile imageFile) {
		
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				
				"cloud_name", "emreguven",
				"api_key", "258324482632571",
				"api_secret", "kyyWpEwOG0fiuwbD_jHeEC77OUo"));
		
		try {
			 Map uploadResult = cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			 return new SuccessDataResult<Map>(uploadResult);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}
	
		
		
}
