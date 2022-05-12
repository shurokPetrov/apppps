package product.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import product.data.ProductResponseDto;
import product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService service;
    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable String id) {
        return service.getProductById(id);
    }

    @GetMapping("/sku/{sku}")
    public List<ProductResponseDto> getProductsBySku(@PathVariable String sku) {
        return service.getProductsBySku(sku);
    }
}
