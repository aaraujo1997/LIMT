package com.limtapp.limt_app.service;

import com.limtapp.limt_app.model.User;
import com.limtapp.limt_app.repos.UserRepository;
import com.limtapp.limt_app.web.DTO.LogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LogService {

    @Autowired
    UserRepository userRepository;

    public List<Double> getRecentWeights(User user)
    {
        assert(user.getWeight_log().size() >= 7);

        List<Double> recent = new ArrayList<Double>();

        for(int i = 0; i < 7; i++)
        {
            recent.add(user.getWeight_log().get(user.getWeight_log().size() - (i - 1)));
        }

        return recent;
    }

    public List<Date> getRecentDates(User user)
    {
        assert(user.getDate_log().size() >= 7);

        List<Date> recent = new ArrayList<Date>();

        for(int i = 0; i < 7; i++)
        {
            recent.add(user.getDate_log().get(user.getDate_log().size() - (i - 1)));
        }

        return recent;
    }

    public List<Integer> getRecentCalories(User user)
    {
        assert(user.getCalories_log().size() >= 7);

        List<Integer> recent = new ArrayList<Integer>();

        for(int i = 0; i < 7; i++)
        {
            recent.add(user.getCalories_log().get(user.getCalories_log().size() - (i - 1)));
        }

        return recent;
    }

    //Receives List of Dates
    //Returns Formatted Dates converted to String (truncates yyyy)
    public List<String> formatDates(List<Date> dates)
    {
        DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

        List<String> formattedDates = new ArrayList<String>();

        for(int i = 0; i < dates.size(); i++)
        {
            String currentDateString = dateFormat.format(dates.get(i));
            formattedDates.add(currentDateString.substring(0,7));
        }

        return formattedDates;

    }

    public void addEntry(LogDto logDto, User user)
    {
        user.addCalories(logDto.getCalories());
        user.addWeight(logDto.getWeight());
        user.addDate(new Date());
    }
}
