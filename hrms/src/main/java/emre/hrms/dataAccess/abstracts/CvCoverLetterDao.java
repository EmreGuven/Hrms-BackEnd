package emre.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import emre.hrms.entities.concretes.CvCoverLetter;

public interface CvCoverLetterDao extends JpaRepository<CvCoverLetter, Integer> {

	CvCoverLetter getById(int id);
}
