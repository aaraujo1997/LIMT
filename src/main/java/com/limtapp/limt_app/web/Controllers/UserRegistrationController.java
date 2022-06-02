package com.limtapp.limt_app.web.Controllers;

import com.limtapp.limt_app.model.User;
import com.limtapp.limt_app.repos.UserRepository;
import com.limtapp.limt_app.web.DTO.NewUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegistrationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String showRegistration(Model model)
    {
        model.addAttribute("user",new NewUserDto());
        return "registration";
    }


    @PostMapping("/registration")
    public String registerUser(@ModelAttribute NewUserDto newUserDTO)
    {
        System.out.println(newUserDTO.toString());
        User user = new User(newUserDTO);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);


        return "redirect:/registration?success";
    }
}
