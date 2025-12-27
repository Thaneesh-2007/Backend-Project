package com.examly.springapp.service;

import com.examly.springapp.model.Booking;
import com.examly.springapp.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    
    @Autowired
    private BookingRepo bookingRepo;
    
    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepo.save(booking);
    }
}