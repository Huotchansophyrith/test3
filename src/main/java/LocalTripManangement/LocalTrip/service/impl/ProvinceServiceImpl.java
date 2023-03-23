package LocalTripManangement.LocalTrip.service.impl;

import LocalTripManangement.LocalTrip.constant.Status;
import LocalTripManangement.LocalTrip.dto.ResponseDTO;
import LocalTripManangement.LocalTrip.dto.provinces.CreateProvinceDto;
import LocalTripManangement.LocalTrip.dto.provinces.UpdateProvinceDto;
import LocalTripManangement.LocalTrip.entiry.Provinces;
import LocalTripManangement.LocalTrip.exception.RequestException;
import LocalTripManangement.LocalTrip.repository.ProvinceRepository;
import LocalTripManangement.LocalTrip.service.ProvinceService;
import org.modelmapper.ModelMapper;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    private static final String FIND_SUCCESS = "Find successfully";
    private static final String CREATE_SUCCESS = "Create successfully";
    private static final String UPDATE_SUCCESS = "Update successfully";
    private static final String DELETE_SUCCESS = "Delete successfully";
    private static final String NOT_FOUND = "Province is not found!";
    private static final String NOT_AVAILABLE = "Province already exist!";

    private ProvinceRepository provinceRepository;
    private ModelMapper modelMapper;
    public ProvinceServiceImpl(ProvinceRepository provinceRepository, ModelMapper modelMapper) {
        this.provinceRepository=provinceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseDTO findAll() {
        Iterable<Provinces> provinces = this.provinceRepository.findAllByStatus(true);
        return new ResponseDTO(FIND_SUCCESS, provinces);
    }

    @Override
    public ResponseDTO findOne(long provinceId)throws RequestException {
        Provinces provinces = this.checkExistingProvince(provinceId);
        return new ResponseDTO(FIND_SUCCESS,provinces);
    }
    @Override
    public ResponseDTO create(CreateProvinceDto createProvinceDto)throws RequestException{
        Optional<Provinces> check = this.provinceRepository.findAllByProvinceName(createProvinceDto.getProvinceName());
        if(check.isEmpty()){
            Provinces provinces= modelMapper.map(createProvinceDto,Provinces.class);
            provinces = this.provinceRepository.save(provinces);
            return new ResponseDTO(CREATE_SUCCESS,provinces);
        }
        return new ResponseDTO(NOT_AVAILABLE, Status.EXIST.value(),409);
    }

    @Override
    public ResponseDTO update(UpdateProvinceDto updateProvinceDto)throws RequestException{
        try{
            this.checkExistingProvince(updateProvinceDto.getId());
            Provinces provinces = modelMapper.map(updateProvinceDto,Provinces.class);
            provinces = this.provinceRepository.save(provinces);
            return new ResponseDTO(UPDATE_SUCCESS,provinces);
        }catch (Exception e){
            return new ResponseDTO("Province already exist",Status.EXIST.value(), 409);
        }
    }

    @Override
    public ResponseDTO delete(long provinceId)throws RequestException{
        Provinces provinces =this.checkExistingProvince(provinceId);
        provinces.setStatus(false);
        this.provinceRepository.save(provinces);
        return new ResponseDTO(DELETE_SUCCESS);
    }

    private Provinces checkExistingProvince(long provinceId) throws RequestException {
        Provinces provinces = this.provinceRepository.findById(provinceId);
        if (provinces != null) {
            return provinces;
        } else {
            throw new RequestException(String.format(NOT_FOUND, provinceId));
        }
    }


}
