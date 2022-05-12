package product.service;

import product.data.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto getProductById(String id);

    List<ProductResponseDto> getProductsBySku(String sku);
}
