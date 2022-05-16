package Inventory.service.impl;

import Inventory.entity.InventoryItem;
import Inventory.repository.ItemRepository;
import Inventory.service.InventoryItemService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InventoryItemServiceImpl implements InventoryItemService {
    private ItemRepository repository;

    @SneakyThrows
    @Override
    public Set<String> getAvailableIds(Set<String> ids) {
        Thread.sleep(2000);
        return repository.findAll().stream()
                .map(InventoryItem::getId)
                .filter(ids::contains)
                .collect(Collectors.toSet());
    }
}
