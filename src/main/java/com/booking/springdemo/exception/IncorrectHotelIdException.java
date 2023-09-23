package com.booking.springdemo.exception;

public class IncorrectHotelIdException extends Exception {
    public IncorrectHotelIdException(String input) {
        super("expected int value found : " + input);
    }
}
