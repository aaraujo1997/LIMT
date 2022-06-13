package com.limtapp.limt_app.web.Controllers;


import com.limtapp.limt_app.model.User;
import com.limtapp.limt_app.repos.UserRepository;
import com.limtapp.limt_app.service.CustomUserDetails;
import com.limtapp.limt_app.service.CustomUserDetailsService;
import com.limtapp.limt_app.service.LogService;
import com.limtapp.limt_app.web.DTO.LogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoggingController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    LogService logService;

    @GetMapping("/log")
    public String viewLog(Model model)
    {
        model.addAttribute("log",new LogDto());

        return "log";
    }


    @PostMapping("/log")
    public String submitLog(@ModelAttribute LogDto logDto, Authentication authentication)
    {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        User currentUser = userRepository.findByEmail(userDetails.getUsername());

        logService.addEntry(logDto,currentUser);
        userRepository.save(currentUser);

        return "redirect:/log?success";
    }
}
