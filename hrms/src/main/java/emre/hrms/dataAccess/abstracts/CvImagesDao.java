package emre.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import emre.hrms.entities.concretes.CvImages;

public interface CvImagesDao extends JpaRepository<CvImages, Integer> {

	CvImages getById(int id);
	
	CvImages getByJobseeker_id(int id);
}
