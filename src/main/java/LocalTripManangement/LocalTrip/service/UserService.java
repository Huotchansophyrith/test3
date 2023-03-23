package LocalTripManangement.LocalTrip.service;


import LocalTripManangement.LocalTrip.dto.ResponseDTO;
import LocalTripManangement.LocalTrip.dto.user.CreateUserDto;
import LocalTripManangement.LocalTrip.dto.user.UpdateUserDto;
import LocalTripManangement.LocalTrip.exception.RequestException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseDTO findAll();

    ResponseDTO findById(int userId) throws RequestException;

    ResponseDTO findAvailableUsername(String username);

    ResponseDTO create(CreateUserDto createUserDto) throws RequestException;

    ResponseDTO update(UpdateUserDto userUpdateDto) throws RequestException;

    ResponseDTO delete(int id) throws RequestException;
}
