package com.inventory.InventoryService.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponseDto {

    private Long id;
    private String itemName;
    private String itemType;
    private int quantity;
    private Long departmentId;
}
