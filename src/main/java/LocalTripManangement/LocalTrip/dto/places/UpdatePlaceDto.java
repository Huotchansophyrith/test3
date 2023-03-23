package LocalTripManangement.LocalTrip.dto.places;

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
public class UpdatePlaceDto extends CreatePlaceDto{

    @Positive(message = "Id must be greater than 0!")
    @NotNull(message = "Id must be not missing!")
    private Long id;
}
