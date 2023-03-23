package LocalTripManangement.LocalTrip.dto.places;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Pattern;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreatePlaceDto {

    private String placeName;
    private String province1;

    private String history;
    private MultipartFile[] file;

    @Pattern(regexp = "^true$|^false$",message = "status's value must be boolean type: true or false")
    private String status = "true";
    private Date createDate = new Date();
    private Date modifyDate = new Date();
}
