package com.inventory.InventoryService.mapper;
import com.inventory.InventoryService.dto.InventoryRequestDto;
import com.inventory.InventoryService.dto.InventoryResponseDto;
import com.inventory.InventoryService.entity.Inventory;
import com.inventory.InventoryService.entity.InventoryItem;

public class InventoryMapper {

    public static InventoryResponseDto mapToDto(Inventory inventory) {
        return InventoryResponseDto.builder()
                .id(inventory.getId())
                .itemName(inventory.getItemName())
                .itemType(inventory.getItemType())
                .quantity(inventory.getQuantity())
                .departmentId(inventory.getDepartmentId())
                .build();
    }

    public static Inventory mapToEntity(InventoryRequestDto dto) {
        return Inventory.builder()
                .itemName(dto.getItemName())
                .itemType(dto.getItemType())
                .quantity(dto.getQuantity())
                .departmentId(dto.getDepartmentId())
                .build();
    }
}