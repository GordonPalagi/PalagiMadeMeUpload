package photocurator.palagimademeupload.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import photocurator.palagimademeupload.model.ImageDTO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcImageService implements ImageService {

    private final JdbcTemplate jdbcTemplate;

    public JdbcImageService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<ImageDTO> listImages() {
        List<ImageDTO> imageList = new ArrayList<>();
        String sql = "SELECT * FROM image";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            ImageDTO imageDTO = new ImageDTO();
            mapRowToImageDTO(results, imageDTO);
            imageList.add(imageDTO);
        }

        return imageList;
    }

//    @Override
//    public Optional<ImageDTO> findImageById(UUID uuid) {
//        return Optional.empty();
//    }
//
//    @Override
//    public ImageDTO saveImage(ImageDTO imageDTO) {
//        return null;
//    }
//
//    @Override
//    public Optional<ImageDTO> updateBeerById(UUID imageId, ImageDTO image) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Boolean deleteById(UUID id) {
//        return null;
//    }
//
//    @Override
//    public HttpResponse<String> uploadImage(ImageDTO imageDTO) {
//        return null;
//    }

    private ImageDTO mapRowToImageDTO(SqlRowSet rowSet, ImageDTO imageDTO) {
        imageDTO.setId(rowSet.getLong("id"));
        imageDTO.setStudentName(rowSet.getString("studentname"));
//        imageDTO.setStudentId(rowSet.getLong("studentid"));
        imageDTO.setTitle(rowSet.getString("title"));
        imageDTO.setDescription(rowSet.getString("description"));
        imageDTO.setImagePath(rowSet.getString("imagepath"));
        Timestamp dateSubmittedTs = rowSet.getTimestamp("datesubmitted");
        if (dateSubmittedTs != null) {
            imageDTO.setDateSubmitted(dateSubmittedTs.toLocalDateTime());
        }
        Timestamp timeSubmittedTs = rowSet.getTimestamp("timesubmitted");
        if (timeSubmittedTs != null) {
            imageDTO.setTimeSubmitted(timeSubmittedTs.toLocalDateTime());
        }
        // Add mapping for studentName if required
        return imageDTO;
    }
}





















