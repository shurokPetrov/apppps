package product.service;

import product.data.InventoryItemDto;

import java.util.List;
import java.util.Set;

public interface InventoryService {
    List<String> getInventoryItems(Set<String> ids);
}
