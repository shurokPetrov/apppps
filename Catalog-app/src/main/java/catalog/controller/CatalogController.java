package catalog.controller;

import catalog.data.CatalogDto;
import catalog.entity.Catalog;
import catalog.repository.CatalogRepository;
import catalog.service.CatalogService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class CatalogController {
    private CatalogService service;


    @GetMapping("/")
    public List<CatalogDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/product/{id}")
    public CatalogDto getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("/{sku}")
    public List<CatalogDto> getBySku(@PathVariable String sku) {
        return service.getCatalogsBySku(sku);
    }

}
