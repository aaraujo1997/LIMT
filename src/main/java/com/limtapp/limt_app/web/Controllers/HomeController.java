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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @GetMapping("/home")
    public String showHome(Model model, Authentication authentication) {
        // Gets users full name for home display
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String name = userDetails.getFullName();
        model.addAttribute("name", name);

        //get user info for chart.js data
        User user = userRepository.findByEmail(userDetails.getUsername());

        List<Double> recentWeight = new ArrayList<Double>();
        List<Integer> recentCalories = new ArrayList<Integer>();
        List<Date> recentDates = new ArrayList<Date>();
        int logSize = user.getDate_log().size();

        //testing default vals
        Long currentTime = System.currentTimeMillis();

        for(int i = 0; i < 14; i++)
        {
            recentDates.add(new Date(currentTime-24*60*60*1000));
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

        model.addAttribute("recentWeight", recentWeight);
        model.addAttribute("recentDates", recentDates);
        model.addAttribute("recentCalories", recentCalories);

        /**
        if (logSize >= 14) {
            for (int i = logSize; i > logSize - 14; i--) {
                recentWeight.add(user.getWeight_log().get(i));
                recentDates.add(user.getDate_log().get(i));
                recentCalories.add(user.getCalories_log().get(i));
            }

            model.addAttribute("recentWeight", recentWeight);
            model.addAttribute("recentDates", recentDates);
            model.addAttribute("recentCalories", recentCalories);

        }
         **/


        return "home";
    }
}