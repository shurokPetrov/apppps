package product.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import product.service.InventoryService;
import product.util.checker.ResponseChecker;
import product.util.convector.Convector;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    private RestTemplate restTemplate;
    private Convector<String> convector;
    private ResponseChecker responseChecker;

    @Override
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),
            @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
    })
    public List<String> getInventoryItems(Set<String> ids) {
        ResponseEntity<String[]> inventoryResponse =
                restTemplate.getForEntity("http://inventory-app/api/inventory/{ids}",
                        String[].class, ids);
        if (responseChecker.responseCheck(inventoryResponse)) {
            log.info(String.format("Get items by %s", ids));
            return convector.convertArrayToList(inventoryResponse.getBody());
        }
        throw new RuntimeException("");
    }
}
