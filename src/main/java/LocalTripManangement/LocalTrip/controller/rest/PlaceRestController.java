package LocalTripManangement.LocalTrip.controller.rest;

import LocalTripManangement.LocalTrip.dto.ResponseDTO;
import LocalTripManangement.LocalTrip.dto.places.CreatePlaceDto;
import LocalTripManangement.LocalTrip.dto.places.UpdatePlaceDto;
import LocalTripManangement.LocalTrip.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;


@RestController
@RequestMapping(value = "/api/v1/places")
public class PlaceRestController {
    @Autowired
    private PlaceService placeService;
    public PlaceRestController(PlaceService placeService){
        this.placeService=placeService;
    }

    @GetMapping
    public ResponseDTO findAll(){return this.placeService.findAll();}

    @GetMapping("/place/{placeId}")
    public ResponseDTO findOne(@PathVariable long placeId){
        return this.placeService.findOne(placeId);
    }

    @PostMapping
    public ResponseDTO create(@RequestBody CreatePlaceDto createPlaceDto) throws LoginException {
        System.out.println(createPlaceDto);
        return null;
//        return this.placeService.create(createPlaceDto);
    }

    @PutMapping
    public ResponseDTO update(@RequestBody UpdatePlaceDto updatePlaceDto){
        return this.placeService.update(updatePlaceDto);
    }
    @DeleteMapping("/delete/{placeId}")
    public ResponseDTO delete(@PathVariable long placeId){
        return this.placeService.delete(placeId);
    }


//    @PostMapping
//    public ResponseEntity uploadImage(@RequestParam("file") MultipartFile imageFile, @ModelAttribute CreatePlaceDto requestDto) {
//        try {
//            ResponseDTO created  =placeService.create(requestDto,imageFile.getBytes())    ;             //(requestDto, file.getBytes());
//            return new ResponseEntity<>(created, HttpStatus.OK);
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
}
