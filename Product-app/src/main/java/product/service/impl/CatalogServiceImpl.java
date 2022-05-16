package product.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000"),
//            @HystrixProperty(name = "coreSize", value = "2"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000")
    })
    public CatalogDto getCatalogById(String id) {
        ResponseEntity<CatalogDto> catalogResponse =
                restTemplate.getForEntity("http://catalog-app/api/catalog/product/{id}",
                        CatalogDto.class, id);
        if (responseChecker.responseCheck(catalogResponse)) {
            log.info(String.format("Get catalog by id %s ", id));
            return catalogResponse.getBody();
        }
        throw new RuntimeException("");
    }

    @Override
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000"),
//            @HystrixProperty(name = "coreSize", value = "2"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000")
    })
    public List<CatalogDto> getCatalogsBySku(String sku) {
        ResponseEntity<CatalogDto[]> catalogResponse =
                restTemplate.getForEntity("http://catalog-app/api/catalog/{sku}",
                        CatalogDto[].class, sku);
        if (responseChecker.responseCheck(catalogResponse)) {
            log.info(String.format("Get catalogs by sku %s ", sku));
            return convector.convertArrayToList(catalogResponse.getBody());
        }
        throw new RuntimeException("");
    }
}
