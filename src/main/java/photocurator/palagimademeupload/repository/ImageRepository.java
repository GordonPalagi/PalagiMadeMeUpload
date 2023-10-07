package photocurator.palagimademeupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photocurator.palagimademeupload.entity.Image;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {
}
