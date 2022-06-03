package com.limtapp.limt_app.web.Controllers;

import com.limtapp.limt_app.model.User;
import com.limtapp.limt_app.repos.UserRepository;
import com.limtapp.limt_app.service.CustomUserDetails;
import com.limtapp.limt_app.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @GetMapping("/home")
    public String showHome(Model model, Authentication authentication)
    {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String name = userDetails.getFullName();
        model.addAttribute("name",name);

        return "home";
    }
}
