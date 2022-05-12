package Inventory.service;

import java.util.Set;

public interface InventoryItemService {
    Set<String> getAvailableIds(Set<String> ids);
}
