package Inventory.controller;

import Inventory.data.InventoryItemDto;
import Inventory.service.InventoryItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory/")
@AllArgsConstructor
public class ItemController {
    private InventoryItemService service;

    @GetMapping("/")
    public List<InventoryItemDto> getAvailableItems() {
        return service.getAllItems();
    }
}
