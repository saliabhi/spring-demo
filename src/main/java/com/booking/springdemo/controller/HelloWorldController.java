package com.booking.springdemo.controller;

import com.booking.springdemo.entity.Hotel;
import com.booking.springdemo.exception.HotelNotFoundException;
import com.booking.springdemo.exception.IncorrectHotelIdException;
import com.booking.springdemo.repository.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController()
@RequestMapping("/booking")
public class HelloWorldController {

    Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/hotel-id/{hotelId}")
    public Hotel getHotelName(@PathVariable("hotelId") String hotelIdString) throws IncorrectHotelIdException {
        logger.info("get by hotel id called with {}", hotelIdString);
        long hotelId;
        try {
            hotelId = Integer.parseInt(hotelIdString);
        } catch (NumberFormatException e) {
            throw new IncorrectHotelIdException(hotelIdString);
        }
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        if (hotel.isPresent()) {
            return hotel.get();
        } else {
            throw new HotelNotFoundException(hotelId);
        }
    }

}
