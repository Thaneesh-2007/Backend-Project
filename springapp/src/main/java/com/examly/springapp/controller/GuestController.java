package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Guest;
import com.examly.springapp.service.GuestService;
import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {
    
    @Autowired
    private GuestService guestService;
    
    @PostMapping
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        Guest saved = guestService.saveGuest(guest);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    
    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuests() {
        List<Guest> guests = guestService.getAllGuests();
        return ResponseEntity.ok(guests);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        Guest guest = guestService.getGuestById(id);
        return ResponseEntity.ok(guest);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        Guest updated = guestService.updateGuest(id, guest);
        return ResponseEntity.ok(updated);
    }
    
    @GetMapping("/phone/{phone}")
    public ResponseEntity<?> getGuestsByPhone(@PathVariable String phone) {
        List<Guest> guests = guestService.getGuestsByPhone(phone);
        if (guests.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No guest found with phone: " + phone);
        }
        return ResponseEntity.ok(guests);
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<List<Guest>> getGuestsByEmail(@PathVariable String email) {
        List<Guest> guests = guestService.getGuestsByEmail(email);
        return ResponseEntity.ok(guests);
    }
}
