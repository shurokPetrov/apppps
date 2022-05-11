package Inventory.service;

import Inventory.data.InventoryItemDto;

import java.util.List;

public interface InventoryItemService {
    List<InventoryItemDto> getAllItems();
}
