package LocalTripManangement.LocalTrip.controller;

import LocalTripManangement.LocalTrip.entiry.Provinces;
import LocalTripManangement.LocalTrip.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "provinces")
public class ProvinceController {

    @Autowired
    private ProvinceRepository provinceRepository;

    @GetMapping ("/list")
    public String list(Model model){
//        model.addAllAttributes("","");
//        model.addAllAttributes("","");

        return "layouts/provinces/list";
    }

    @GetMapping ("/add")
    public String add(Model model){
//        model.addAllAttributes("","");
//        model.addAllAttributes("","");

        return "layouts/provinces/create-update-province";
    }
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){

        Provinces provinces = this.provinceRepository.findByIdAndStatus(id,true);
        model.addAttribute("provinces",provinces);

        return "/layouts/provinces/update";
    }

}
