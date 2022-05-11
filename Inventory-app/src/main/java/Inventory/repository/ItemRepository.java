package Inventory.repository;

import Inventory.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<InventoryItem, String> {
}
