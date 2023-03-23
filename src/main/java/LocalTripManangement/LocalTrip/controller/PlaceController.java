package LocalTripManangement.LocalTrip.controller;

import LocalTripManangement.LocalTrip.dto.ResponseDTO;
import LocalTripManangement.LocalTrip.dto.places.CreatePlaceDto;
import LocalTripManangement.LocalTrip.entiry.Places;
import LocalTripManangement.LocalTrip.repository.PlacesRepository;
import LocalTripManangement.LocalTrip.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(value = "places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    private PlacesRepository placesRepository;
    public PlaceController (PlacesRepository placesRepository){
        this.placesRepository=placesRepository;
    }

    @GetMapping ("/add")
    public String add (Model model){
        return "layouts/places/create-update";
    }
    @GetMapping ("/homepage")
    public String homepage (Model model){
        return "layouts/homepageTest";
    }


    @Value("${dir.path}")
    private String UPLOAD_DIRECTORY;
    @GetMapping("/list")
    public String list(Model model){
        return "layouts/places/list1";
    }
    @GetMapping("/update/{id}")
    public String update(Model model , @PathVariable Long id){
        Places places = this.placesRepository.findByIdAndStatus(id,true);
        model.addAttribute("places",places);

        return "/layouts/places/update";

    }
    @GetMapping("/place-page/{id}")
    public String placePage(Model model,@PathVariable Long id){

        Places places = this.placesRepository.findByIdAndStatus(id,true);
        System.out.println(places);

        model.addAttribute("places",places);

        return "layouts/places/place-page";
    }

//    @GetMapping("/places/add") public String displayUploadForm() {
//        return "places/add";
//    }
//
//    @PostMapping("/upload")
//    public ResponseDTO handleFileUpload(CreatePlaceDto createPlaceDto) throws LoginException {
//        return placeService.create(createPlaceDto);
//    }


}
