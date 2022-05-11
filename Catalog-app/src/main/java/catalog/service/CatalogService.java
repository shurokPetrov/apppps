package catalog.service;

import catalog.data.CatalogDto;

import java.util.List;

public interface CatalogService {
    List<CatalogDto> getAll();

    List<CatalogDto> getCatalogsBySku(String sku);

    CatalogDto getById(String id);
}
