package catalog.controller;

import catalog.data.CatalogDto;
import catalog.service.CatalogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
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
