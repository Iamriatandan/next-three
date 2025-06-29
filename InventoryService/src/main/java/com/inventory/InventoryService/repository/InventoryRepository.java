package com.inventory.InventoryService.repository;
import com.inventory.InventoryService.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    // Find inventory items by department ID
    List<Inventory> findByDepartmentId(Long departmentId);
}