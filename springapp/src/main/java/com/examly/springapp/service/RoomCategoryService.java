package com.examly.springapp.service;

import com.examly.springapp.model.RoomCategory;
import org.springframework.data.domain.Page;
import java.util.List;

public interface RoomCategoryService {
    RoomCategory saveRoomCategory(RoomCategory roomCategory);
    List<RoomCategory> getAllRoomCategories();
    RoomCategory getRoomCategoryById(Long id);
    RoomCategory updateRoomCategory(Long id, RoomCategory roomCategory);
    void deleteRoomCategory(Long id);
    Page<RoomCategory> getRoomCategoriesWithPagination(int page, int size);
}