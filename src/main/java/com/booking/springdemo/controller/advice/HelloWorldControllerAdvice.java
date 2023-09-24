package com.booking.springdemo.controller.advice;

import com.booking.springdemo.exception.HotelNotFoundException;
import com.booking.springdemo.exception.IncorrectHotelIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HelloWorldControllerAdvice {

    @ResponseBody
    @ExceptionHandler(IncorrectHotelIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String incorrectHotelIdHandler(Exception ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(HotelNotFoundException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    String hotelNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }
}
