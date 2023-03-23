package LocalTripManangement.LocalTrip.dto.provinces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class CreateProvinceDto {

    private String provinceName;
    private String description;


    @Pattern(regexp = "^true$|^false$", message = "status's value must be boolean type: true or false!")
    private String status = "true";
    private Date createDate = new Date();
    private Date modifyDate = new Date();
}
