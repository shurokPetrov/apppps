package catalog.service.impl;

import catalog.data.CatalogDto;
import catalog.entity.Catalog;
import catalog.repository.CatalogRepository;
import catalog.service.CatalogService;
import catalog.util.mapper.CatalogMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {
    private CatalogMapper mapper;
    private CatalogRepository repository;

    @Override
    public List<CatalogDto> getAll() {
        return repository.findAll().stream()
                .map(value -> mapper.mapToDto(value))
                .collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public List<CatalogDto> getCatalogsBySku(String sku) {
        Thread.sleep(2000);
        return repository.getCatalogsBySku(sku).stream()
                .map(value -> mapper.mapToDto(value))
                .collect(Collectors.toList());
    }

    @Override
    public CatalogDto getById(String id) {
        Catalog catalog = Optional.ofNullable(repository.getById(id)).orElseGet(() -> new Catalog());
        return mapper.mapToDto(catalog);
    }
}
