package photocurator.palagimademeupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photocurator.palagimademeupload.entity.Images;

public interface ImageRepository extends JpaRepository<Images, Long> {
}
