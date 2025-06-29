package com.inventory.InventoryService.controller;
import com.inventory.InventoryService.dto.InventoryRequestDto;
import com.inventory.InventoryService.dto.InventoryResponseDto;
import com.inventory.InventoryService.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    // Create inventory item (MANAGER-only via API Gateway)
    @PostMapping
    public ResponseEntity<InventoryResponseDto> createInventory(@Valid @RequestBody InventoryRequestDto requestDto) {
        log.info("Request received to create inventory: {}", requestDto.getItemName());
        return ResponseEntity.ok(inventoryService.createInventory(requestDto));
    }

    // Get all inventory items
    @GetMapping
    public ResponseEntity<List<InventoryResponseDto>> getAllInventory() {
        log.info("Request received to fetch all inventory items");
        return ResponseEntity.ok(inventoryService.getAllInventory());
    }

    // Get inventory item by ID
    @GetMapping("/{id}")
    public ResponseEntity<InventoryResponseDto> getInventoryById(@PathVariable Long id) {
        log.info("Request received to fetch inventory with ID: {}", id);
        return ResponseEntity.ok(inventoryService.getInventoryById(id));
    }

    // Get inventory by department ID (For MANAGER or Department Service Feign)
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<InventoryResponseDto>> getInventoryByDepartment(@PathVariable Long departmentId) {
        log.info("Request received to fetch inventory for department ID: {}", departmentId);
        return ResponseEntity.ok(inventoryService.getInventoryByDepartmentId(departmentId));
    }

    // Update inventory item
    @PutMapping("/{id}")
    public ResponseEntity<InventoryResponseDto> updateInventory(
            @PathVariable Long id,
            @Valid @RequestBody InventoryRequestDto requestDto) {
        log.info("Request received to update inventory with ID: {}", id);
        return ResponseEntity.ok(inventoryService.updateInventory(id, requestDto));
    }

    // Delete inventory item
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable Long id) {
        log.info("Request received to delete inventory with ID: {}", id);
        inventoryService.deleteInventory(id);
        return ResponseEntity.ok("Inventory item with ID " + id + " deleted successfully.");
    }
}