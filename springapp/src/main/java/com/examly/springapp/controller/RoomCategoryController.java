package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.service.RoomCategoryService;
import java.util.List;

@RestController
@RequestMapping("/api/room-categories")
public class RoomCategoryController {
    
    @Autowired
    private RoomCategoryService roomCategoryService;
    
    @PostMapping
    public ResponseEntity<RoomCategory> createCategory(@RequestBody RoomCategory roomCategory) {
        if (roomCategory == null || roomCategory.getCategoryName() == null) {
            return ResponseEntity.badRequest().build();
        }
        RoomCategory saved = roomCategoryService.saveRoomCategory(roomCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    
    @GetMapping
    public ResponseEntity<List<RoomCategory>> getAllCategories() {
        List<RoomCategory> categories = roomCategoryService.getAllRoomCategories();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        try {
            RoomCategory category = roomCategoryService.getRoomCategoryById(id);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room category not found");
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RoomCategory> updateCategory(@PathVariable Long id, @RequestBody RoomCategory roomCategory) {
        RoomCategory updated = roomCategoryService.updateRoomCategory(id, roomCategory);
        return ResponseEntity.ok(updated);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        roomCategoryService.deleteRoomCategory(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<RoomCategory>> getCategoriesWithPagination(@PathVariable int page, @PathVariable int size) {
        Page<RoomCategory> categories = roomCategoryService.getRoomCategoriesWithPagination(page, size);
        return ResponseEntity.ok(categories);
    }
}
