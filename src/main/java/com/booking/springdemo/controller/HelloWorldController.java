package com.booking.springdemo.controller;

import com.booking.springdemo.exception.IncorrectHotelIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/booking")
public class HelloWorldController {

    Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/hotel-id/{hotelId}")
    public String getHotelName(@PathVariable("hotelId") String hotelIdString) throws IncorrectHotelIdException {
        logger.info("get by hotel id called with {}",hotelIdString);
        int hotelId;
        try {
            hotelId = Integer.parseInt(hotelIdString);
        } catch (NumberFormatException e) {
            throw new IncorrectHotelIdException(hotelIdString);
        }
        return "Liverpool One" + hotelId;
    }

}
