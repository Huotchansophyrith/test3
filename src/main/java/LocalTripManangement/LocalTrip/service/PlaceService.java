package LocalTripManangement.LocalTrip.service;

import LocalTripManangement.LocalTrip.dto.ResponseDTO;
import LocalTripManangement.LocalTrip.dto.places.CreatePlaceDto;
import LocalTripManangement.LocalTrip.dto.places.UpdatePlaceDto;
import LocalTripManangement.LocalTrip.exception.RequestException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public interface PlaceService {

    ResponseDTO findAll();

    ResponseDTO findOne(long placeId)throws RequestException;

    ResponseDTO create(CreatePlaceDto createPlaceDto)throws LoginException  ;

    ResponseDTO update(UpdatePlaceDto updatePlaceDto)throws RequestException;

    ResponseDTO delete(long id)throws RequestException;
    
}
