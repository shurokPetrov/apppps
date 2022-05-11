package Inventory.data;

import lombok.Data;
@Data
public class InventoryItemDto {
    private String id;
    private String sku;
    private Boolean available;
}
