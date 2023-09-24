package com.booking.springdemo.exception;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(long id) {
        super("hotel not found with id " + id);
    }
}
