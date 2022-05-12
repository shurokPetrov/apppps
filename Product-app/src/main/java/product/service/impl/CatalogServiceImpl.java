package product.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import product.data.CatalogDto;
import product.service.CatalogService;
import product.util.checker.ResponseChecker;
import product.util.convector.Convector;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CatalogServiceImpl implements CatalogService {
    private RestTemplate restTemplate;
    private Convector<CatalogDto> convector;
    private ResponseChecker responseChecker;

    @Override
    public CatalogDto getCatalogById(String id) {
        ResponseEntity<CatalogDto> catalogResponse =
                restTemplate.getForEntity("http://catalog-app/api/catalog/product/{id}",
                        CatalogDto.class, id);
        if (responseChecker.responseCheck(catalogResponse)) {
            return catalogResponse.getBody();
        }
        throw new RuntimeException("");
    }

    @Override
    public List<CatalogDto> getCatalogsBySku(String sku) {
        ResponseEntity<CatalogDto[]> catalogResponse =
                restTemplate.getForEntity("http://catalog-app/api/catalog/{sku}",
                        CatalogDto[].class, sku);
        if (responseChecker.responseCheck(catalogResponse)) {
            return convector.convertArrayToList(catalogResponse.getBody());
        }
        throw new RuntimeException("");
    }
}
