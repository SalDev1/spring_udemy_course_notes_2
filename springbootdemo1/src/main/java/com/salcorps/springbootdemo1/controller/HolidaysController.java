package com.salcorps.springbootdemo1.controller;

import com.salcorps.springbootdemo1.model.Holiday;
import com.salcorps.springbootdemo1.repository.HolidaysRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class HolidaysController {
    @Autowired
    public HolidaysRepository holidaysRepository;

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model) {

      if(null != display && display.equals("all")) {
          model.addAttribute("festival",true);
          model.addAttribute("federal",true);
      } else if(null != display && display.equals("federal")) {
          model.addAttribute("federal",true);
      } else {
          model.addAttribute("festival",true);
      }

       List<Holiday> holidays = holidaysRepository.findAllHolidays();
        // Displaying the list of holidays based on the type of holiday.
        Holiday.Type[] types = Holiday.Type.values();
        for(Holiday.Type type : types) {
            model.addAttribute(type.toString(), (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}
