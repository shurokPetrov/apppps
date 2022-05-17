package product.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import product.data.CatalogDto;
import product.data.ProductResponseDto;
import product.service.CatalogService;
import product.service.InventoryService;
import product.service.ProductService;
import product.util.mapper.ProductMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private CatalogService catalogService;
    private InventoryService inventoryService;
    private ProductMapper mapper;

    @Override
    public ProductResponseDto getProductById(String id) {
        CatalogDto dto = catalogService.getCatalogById(id);
        inventoryService.getInventoryItems(Set.of(dto.getId())).stream()
                .filter(i -> i.equals(id))
                .findFirst().orElseThrow(RuntimeException::new);
        return mapper.mapToProductResponseDto(dto);
    }

    @Override
    public List<ProductResponseDto> getProductsBySku(String sku) {
        List<CatalogDto> catalogsBySku = catalogService.getCatalogsBySku(sku);
        Set<String> ids = catalogsBySku.stream()
                .map(CatalogDto::getId)
                .collect(Collectors.toSet());
        Set<String> setOfAvailableIds = new HashSet<>(inventoryService.getInventoryItems(ids));

        return catalogsBySku.stream()
                .filter(x -> setOfAvailableIds.contains(x.getId()))
                .map(x -> mapper.mapToProductResponseDto(x))
                .collect(Collectors.toList());
    }
}
