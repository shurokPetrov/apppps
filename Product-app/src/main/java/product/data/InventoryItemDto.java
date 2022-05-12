package product.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryItemDto {
    private String id;
    private String sku;
    private Boolean available;
}
