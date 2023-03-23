package LocalTripManangement.LocalTrip.dto.provinces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UpdateProvinceDto extends CreateProvinceDto{

    @Positive(message = "id must greater than 0!")
    @NotNull(message = "id must be not missing!")
    private Long id;
}
