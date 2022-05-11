package Inventory.util.mapper;

import Inventory.data.InventoryItemDto;
import Inventory.entity.InventoryItem;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface InventoryMapper {
    InventoryItemDto mapToItemDto(InventoryItem item);
}
