package photocurator.palagimademeupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photocurator.palagimademeupload.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
