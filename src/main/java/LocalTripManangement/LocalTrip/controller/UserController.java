package LocalTripManangement.LocalTrip.controller;

import LocalTripManangement.LocalTrip.entiry.User;
import LocalTripManangement.LocalTrip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public String list() {

        return "layouts/users/list";
    }
    @GetMapping("/myProfile")
    public String myProfile(){
        return "layouts/homepageTest";
    }

    @GetMapping("/add")
    public String add() {

        return "layouts/users/create-update";
    }
    @GetMapping("/login")
    public String login() {

        return "layouts/users/login1";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable Integer id) {
        User user = this.userRepository.findByIdAndStatus(id, true);
        model.addAttribute("user", user);
//        model.addAttribute("userId", id);
//        model.addAttribute("action", "update");
//        model.addAttribute("mUserOpen", "menu-open");
//        model.addAttribute("mUCActive", "active");
        return "layouts/users/update";
    }

}
