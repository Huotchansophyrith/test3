package LocalTripManangement.LocalTrip.service.impl;

import LocalTripManangement.LocalTrip.constant.Status;
import LocalTripManangement.LocalTrip.dto.ResponseDTO;
import LocalTripManangement.LocalTrip.dto.places.CreatePlaceDto;
import LocalTripManangement.LocalTrip.dto.places.UpdatePlaceDto;
import LocalTripManangement.LocalTrip.entiry.Places;
import LocalTripManangement.LocalTrip.exception.RequestException;
import LocalTripManangement.LocalTrip.repository.PlacesRepository;
import LocalTripManangement.LocalTrip.service.PlaceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
@Service
public class PlaceServiceImpl implements PlaceService {

    private static final String FIND_SUCCESS = "Find successfully";
    private static final String CREATE_SUCCESS = "Create successfully";
    private static final String UPDATE_SUCCESS = "Update successfully";
    private static final String DELETE_SUCCESS = "Delete successfully";
    private static final String NOT_FOUND = "Place is not found!";
    private static final String NOT_AVAILABLE = "Place already exist!";

    private PlacesRepository placesRepository;
    private ModelMapper modelMapper;

    public PlaceServiceImpl(PlacesRepository placesRepository, ModelMapper modelMapper){
        this.placesRepository=placesRepository;
        this.modelMapper=modelMapper;

    }
    @Override
    public ResponseDTO findAll(){
        Iterable <Places> places = this.placesRepository.findAllByStatus(true);
        return new ResponseDTO(FIND_SUCCESS,places);
    }
    @Override
    public ResponseDTO findOne(long placeId)throws RequestException{
        Places places  =  this.checkExistingPlace(placeId);
        return new ResponseDTO(FIND_SUCCESS,places);
    }

    @Override
    public ResponseDTO create(CreatePlaceDto createPlaceDto)throws RequestException{
        Optional<Places> check = this.placesRepository.findAllByPlaceName(createPlaceDto.getPlaceName());
        if(check.isEmpty()){
            Places places = modelMapper.map(createPlaceDto,Places.class);
            places = this.placesRepository.save(places);
            return new ResponseDTO(CREATE_SUCCESS,places);
        }
        return new ResponseDTO(NOT_AVAILABLE, Status.EXIST.value(),409);
    }


    @Override
    public ResponseDTO update(UpdatePlaceDto updatePlaceDto)throws RequestException{
        System.out.println(updatePlaceDto);
        try{
            this.checkExistingPlace(updatePlaceDto.getId());
            Places places = this.modelMapper.map(updatePlaceDto,Places.class);
            places = this.placesRepository.save(places);
            return new ResponseDTO(UPDATE_SUCCESS,places);
        }catch (Exception e){
            return new ResponseDTO(NOT_AVAILABLE,Status.EXIST.value(),555);
        }
    }
    @Override
    public ResponseDTO delete(long id)throws RequestException{
        Places places = this.checkExistingPlace(id);
        places.setStatus(false);
        this.placesRepository.save(places);
        return new ResponseDTO(DELETE_SUCCESS);

    }

    private Places checkExistingPlace (long placeId)throws RequestException{
        Places places = this.placesRepository.findById(placeId);
        if(places != null){
            return places;
        }
         throw new RequestException(String.format(NOT_FOUND,placeId));
    }


}
