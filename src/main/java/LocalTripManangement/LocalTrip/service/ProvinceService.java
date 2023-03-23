package LocalTripManangement.LocalTrip.service;

import LocalTripManangement.LocalTrip.dto.ResponseDTO;
import LocalTripManangement.LocalTrip.dto.provinces.CreateProvinceDto;
import LocalTripManangement.LocalTrip.dto.provinces.UpdateProvinceDto;
import LocalTripManangement.LocalTrip.exception.RequestException;
import org.springframework.stereotype.Service;

@Service
public interface ProvinceService {

    ResponseDTO findAll();

    ResponseDTO findOne(long provinceId)throws RequestException;

    ResponseDTO create(CreateProvinceDto createProvinceDto)throws RequestException;

    ResponseDTO update(UpdateProvinceDto updateProvinceDto) ;

    ResponseDTO delete(long provinceId);
}
