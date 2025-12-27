package com.examly.springapp.service;

import com.examly.springapp.model.Guest;
import com.examly.springapp.repository.GuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {
    
    @Autowired
    private GuestRepo guestRepo;
    
    @Override
    public Guest saveGuest(Guest guest) {
        return guestRepo.save(guest);
    }
    
    @Override
    public List<Guest> getAllGuests() {
        return guestRepo.findAll();
    }
    
    @Override
    public Guest getGuestById(Long id) {
        return guestRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Guest not found"));
    }
    
    @Override
    public Guest updateGuest(Long id, Guest guest) {
        Guest existing = getGuestById(id);
        existing.setName(guest.getName());
        existing.setPhone(guest.getPhone());
        existing.setEmail(guest.getEmail());
        return guestRepo.save(existing);
    }
    
    @Override
    public List<Guest> getGuestsByPhone(String phone) {
        return guestRepo.findByPhone(phone);
    }
    
    @Override
    public List<Guest> getGuestsByEmail(String email) {
        return guestRepo.findByEmail(email);
    }
}