package com.examly.springapp.service;

import com.examly.springapp.model.Room;
import com.examly.springapp.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    
    @Autowired
    private RoomRepo roomRepo;
    
    @Override
    public Room saveRoom(Room room) {
        return roomRepo.save(room);
    }
    
    @Override
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }
    
    @Override
    public Room getRoomById(Long id) {
        return roomRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found"));
    }
    
    @Override
    public Room updateRoom(Long id, Room room) {
        Room existing = getRoomById(id);
        existing.setRoomNumber(room.getRoomNumber());
        existing.setPricePerNight(room.getPricePerNight());
        existing.setAvailable(room.getAvailable());
        existing.setRoomCategory(room.getRoomCategory());
        return roomRepo.save(existing);
    }
    
    @Override
    public List<Room> getRoomsByCategory(String categoryName) {
        return roomRepo.findByRoomCategory_CategoryName(categoryName);
    }
    
    @Override
    public List<Room> getRoomsByNumber(String roomNumber) {
        List<Room> rooms = roomRepo.findByRoomNumber(roomNumber);
        if (rooms.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No room found with number: " + roomNumber);
        }
        return rooms;
    }
}