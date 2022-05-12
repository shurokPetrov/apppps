package Inventory.controller;

import Inventory.service.InventoryItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/inventory")
@AllArgsConstructor
public class ItemController {
    private InventoryItemService service;

    @GetMapping("/{ids}")
    public Set<String> getAvailableItems(@PathVariable Set<String> ids) {
        return service.getAvailableIds(ids);
    }
}
