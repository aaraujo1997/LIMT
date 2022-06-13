package com.limtapp.limt_app.web.Controllers;

import com.limtapp.limt_app.model.User;
import com.limtapp.limt_app.repos.UserRepository;
import com.limtapp.limt_app.service.CustomUserDetails;
import com.limtapp.limt_app.service.CustomUserDetailsService;
import com.limtapp.limt_app.service.LogService;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    LogService logService;

    @GetMapping("/home")
    public String showHome(Model model, Authentication authentication) {
        // Gets current users full name for home display
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String name = userDetails.getFullName();
        model.addAttribute("name", name);

        //get user info for chart.js data
        User user = userRepository.findByEmail(userDetails.getUsername());

        List<Double> recentWeight = new ArrayList<Double>();
        List<Integer> recentCalories = new ArrayList<Integer>();
        List<Date> recentDates = new ArrayList<Date>();

        //testing default values
        Long currentTime = System.currentTimeMillis();
        //populate three lists for example
        for(int i = 0; i < 7; i++)
        {
            //add dates from today backwards
            Date currentDate = new Date(currentTime-24*60*60*1000);
            recentDates.add(currentDate);

            currentTime -= 24*60*60*1000;

            if(i % 2 == 0)
            {
                recentCalories.add(2500);
                recentWeight.add(230.00);
            }
            else{
                recentCalories.add(3000);
                recentWeight.add(235.00);
            }
        }

        List<String> formattedDates = logService.formatDates(recentDates);

        Collections.reverse(recentCalories);
        Collections.reverse(recentWeight);
        Collections.reverse(formattedDates);

        model.addAttribute("recentWeight", recentWeight);
        model.addAttribute("recentDates", formattedDates);
        model.addAttribute("recentCalories", recentCalories);

        return "home";
    }
}