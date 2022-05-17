package product.service;

import java.util.List;
import java.util.Set;

public interface InventoryService {
    List<String> getInventoryItems(Set<String> ids);
}
