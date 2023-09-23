package com.booking.springdemo.controller;

import com.booking.springdemo.exception.IncorrectHotelIdException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/booking")
public class HelloWorldController {
    @GetMapping("/hotel-id/{hotelId}")
    public String getHotelName(@PathVariable("hotelId") String hotelIdString) throws IncorrectHotelIdException {
        Integer hotelId = null;
        try {
            hotelId = Integer.parseInt(hotelIdString);
        } catch (NumberFormatException e) {
            throw new IncorrectHotelIdException(hotelIdString);
        }
        return "Liverpool One" + hotelId;
    }

}
