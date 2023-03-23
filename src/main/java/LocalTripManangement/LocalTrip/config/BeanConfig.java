package LocalTripManangement.LocalTrip.config;


import LocalTripManangement.LocalTrip.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfig {

    private UserRepository userRepository;
    public BeanConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public BCryptPasswordEncoder encoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public void createDefaultUser(){
//        User existingUser = this.userRepository.findByUsername("admin");
//
//        if(existingUser == null){
//            User user = new User();
//            user.setUsername("Admin");
//            user.setUsername("admin");
//            user.setPassword(this.encoder().encode("123456"));
//            user.setStatus(true);
//            this.userRepository.save(user);
//        }
//
//    }

}
