package com.inventory.InventoryService.service.impl;

import com.inventory.InventoryService.dto.InventoryRequestDto;
import com.inventory.InventoryService.dto.InventoryResponseDto;
import com.inventory.InventoryService.entity.Inventory;
import com.inventory.InventoryService.exception.InventoryItemNotFoundException;
import com.inventory.InventoryService.mapper.InventoryMapper;
import com.inventory.InventoryService.repository.InventoryRepository;
import com.inventory.InventoryService.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public InventoryResponseDto createInventory(InventoryRequestDto requestDto) {
        log.info("Creating inventory item: {}", requestDto.getItemName());
        Inventory inventory = InventoryMapper.mapToEntity(requestDto);
        Inventory saved = inventoryRepository.save(inventory);
        log.debug("Inventory created successfully with ID: {}", saved.getId());
        return InventoryMapper.mapToDto(saved);
    }

    @Override
    public List<InventoryResponseDto> getAllInventory() {
        log.info("Fetching all inventory items");
        return inventoryRepository.findAll()
                .stream()
                .map(InventoryMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public InventoryResponseDto getInventoryById(Long id) {
        log.info("Fetching inventory item with ID: {}", id);
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new InventoryItemNotFoundException("Inventory", "id", id));
        return InventoryMapper.mapToDto(inventory);
    }

    @Override
    public List<InventoryResponseDto> getInventoryByDepartmentId(Long departmentId) {
        log.info("Fetching inventory for department ID: {}", departmentId);
        return inventoryRepository.findByDepartmentId(departmentId)
                .stream()
                .map(InventoryMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public InventoryResponseDto updateInventory(Long id, InventoryRequestDto requestDto) {
        log.info("Updating inventory with ID: {}", id);
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new InventoryItemNotFoundException("Inventory", "id", id));

        inventory.setItemName(requestDto.getItemName());
        inventory.setItemType(requestDto.getItemType());
        inventory.setQuantity(requestDto.getQuantity());
        inventory.setDepartmentId(requestDto.getDepartmentId());

        Inventory updated = inventoryRepository.save(inventory);
        log.debug("Inventory updated successfully with ID: {}", updated.getId());
        return InventoryMapper.mapToDto(updated);
    }

    @Override
    public void deleteInventory(Long id) {
        log.info("Deleting inventory with ID: {}", id);
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new InventoryItemNotFoundException("Inventory", "id", id));
        inventoryRepository.delete(inventory);
        log.debug("Inventory deleted successfully with ID: {}", id);
    }
}