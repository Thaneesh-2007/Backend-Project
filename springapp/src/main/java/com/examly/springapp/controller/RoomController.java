package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Room;
import com.examly.springapp.service.RoomService;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    
    @Autowired
    private RoomService roomService;
    
    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room saved = roomService.saveRoom(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    
    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Room room = roomService.getRoomById(id);
        return ResponseEntity.ok(room);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room) {
        Room updated = roomService.updateRoom(id, room);
        return ResponseEntity.ok(updated);
    }
    
    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Room>> getRoomsByCategory(@PathVariable String categoryName) {
        List<Room> rooms = roomService.getRoomsByCategory(categoryName);
        return ResponseEntity.ok(rooms);
    }
    
    @GetMapping("/number/{roomNumber}")
    public ResponseEntity<?> getRoomsByNumber(@PathVariable String roomNumber) {
        try {
            List<Room> rooms = roomService.getRoomsByNumber(roomNumber);
            return ResponseEntity.ok(rooms);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No room found with number: " + roomNumber);
        }
    }
}
