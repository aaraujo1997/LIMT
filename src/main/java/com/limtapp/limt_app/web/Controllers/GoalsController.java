package com.limtapp.limt_app.web.Controllers;


import com.limtapp.limt_app.repos.UserRepository;
import com.limtapp.limt_app.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GoalsController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailsService customUserDetailsService;


}
