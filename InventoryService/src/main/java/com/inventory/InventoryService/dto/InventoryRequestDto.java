package com.inventory.InventoryService.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryRequestDto {

    @NotBlank(message = "Item name is required")
    private String itemName;

    private String itemType;

    @Min(value = 0, message = "Quantity cannot be negative")
    private int quantity;

    @NotNull(message = "Department ID is required")
    private Long departmentId;
}
