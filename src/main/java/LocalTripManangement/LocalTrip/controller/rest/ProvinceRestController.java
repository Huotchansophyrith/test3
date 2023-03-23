package LocalTripManangement.LocalTrip.controller.rest;


import LocalTripManangement.LocalTrip.dto.ResponseDTO;
import LocalTripManangement.LocalTrip.dto.provinces.CreateProvinceDto;
import LocalTripManangement.LocalTrip.dto.provinces.UpdateProvinceDto;
import LocalTripManangement.LocalTrip.exception.RequestException;
import LocalTripManangement.LocalTrip.service.ProvinceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/provinces")
public class ProvinceRestController {

    private ProvinceService provinceService;
    public ProvinceRestController(ProvinceService  provinceService){
        this.provinceService=provinceService;
    }

    @GetMapping
    public ResponseDTO findAll(){
        return this.provinceService.findAll();
    }

    @GetMapping("/province/{provinceId}")
    public ResponseDTO findOne(@PathVariable long provinceId)throws RequestException {
        return this.provinceService.findOne(provinceId);
    }

    @PostMapping
    public ResponseDTO create(@RequestBody CreateProvinceDto createProvinceDto)throws RequestException{
        return this.provinceService.create(createProvinceDto);
    }

    @PutMapping
    public ResponseDTO update(@RequestBody UpdateProvinceDto updateProvinceDto){
        return this.provinceService.update(updateProvinceDto);
    }

    @DeleteMapping("/delete/{provinceId}")
    public ResponseDTO delete(@PathVariable long provinceId){
        return this.provinceService.delete(provinceId);
    }

}
