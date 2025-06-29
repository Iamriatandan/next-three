package com.hotel.department_service.feign;
import com.hotel.department_service.dto.InventoryResponseDto;
import com.hotel.departmentservice.dto.InventoryResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "INVENTORY-SERVICE")
public interface InventoryClient {

    @GetMapping("/inventory/department/{departmentId}")
    List<InventoryResponseDto> getInventoryByDepartment(@PathVariable Long departmentId);
}