package com.examly.springapp.service;

import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.repository.RoomCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {
    
    @Autowired
    private RoomCategoryRepo roomCategoryRepo;
    
    @Override
    public RoomCategory saveRoomCategory(RoomCategory roomCategory) {
        return roomCategoryRepo.save(roomCategory);
    }
    
    @Override
    public List<RoomCategory> getAllRoomCategories() {
        return roomCategoryRepo.findAll();
    }
    
    @Override
    public RoomCategory getRoomCategoryById(Long id) {
        return roomCategoryRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room category not found"));
    }
    
    @Override
    public RoomCategory updateRoomCategory(Long id, RoomCategory roomCategory) {
        RoomCategory existing = getRoomCategoryById(id);
        existing.setCategoryName(roomCategory.getCategoryName());
        return roomCategoryRepo.save(existing);
    }
    
    @Override
    public void deleteRoomCategory(Long id) {
        roomCategoryRepo.deleteById(id);
    }
    
    @Override
    public Page<RoomCategory> getRoomCategoriesWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return roomCategoryRepo.findAll(pageable);
    }
}