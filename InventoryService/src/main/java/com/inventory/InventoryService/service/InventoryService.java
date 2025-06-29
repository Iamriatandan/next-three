package com.inventory.InventoryService.service;
import com.inventory.InventoryService.dto.InventoryRequestDto;
import com.inventory.InventoryService.dto.InventoryResponseDto;

import java.util.List;

public interface InventoryService {

    InventoryResponseDto createInventory(InventoryRequestDto requestDto);

    List<InventoryResponseDto> getAllInventory();

    InventoryResponseDto getInventoryById(Long id);

    List<InventoryResponseDto> getInventoryByDepartmentId(Long departmentId);

    InventoryResponseDto updateInventory(Long id, InventoryRequestDto requestDto);

    void deleteInventory(Long id);
}
