package product.service;

import product.data.CatalogDto;

import java.util.List;

public interface CatalogService {
    CatalogDto getCatalogById(String id);

    List<CatalogDto> getCatalogsBySku(String sku);
}
