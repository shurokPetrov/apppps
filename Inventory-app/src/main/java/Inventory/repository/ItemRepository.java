package Inventory.repository;

import Inventory.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ItemRepository extends JpaRepository<InventoryItem, String> {
    List<InventoryItem> getInventoryItemByIdIn(Set<String> ids);
}
