package product.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import product.data.InventoryItemDto;
import product.service.InventoryService;
import product.util.checker.ResponseChecker;
import product.util.convector.Convector;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private RestTemplate restTemplate;
    private Convector<String> convector;
    private ResponseChecker responseChecker;

    @Override
    public List<String> getInventoryItems(Set<String> ids) {
        ResponseEntity<String[]> inventoryResponse =
                restTemplate.getForEntity("http://inventory-app/api/inventory/{ids}",
                        String[].class, ids);
        if (responseChecker.responseCheck(inventoryResponse)) {
            return convector.convertArrayToList(inventoryResponse.getBody());
        }
        throw new RuntimeException("");
    }
}
