package product.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {
    private String id;
    private String sku;
    private String name;
    private String description;
    private BigDecimal listPrice;
    private BigDecimal salePrice;
    private String category;
    private String categoryTree;
    private String averageRating;
    private String productUrl;
    private String productImageUrl;
    private String brand;
    private String numberOfReviews;
    private String reviews;
}
