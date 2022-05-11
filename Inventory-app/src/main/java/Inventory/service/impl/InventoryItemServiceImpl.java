package Inventory.service.impl;

import Inventory.data.InventoryItemDto;
import Inventory.repository.ItemRepository;
import Inventory.service.InventoryItemService;
import Inventory.util.mapper.InventoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InventoryItemServiceImpl implements InventoryItemService {
    private ItemRepository repository;
    private InventoryMapper mapper;

    @Override
    public List<InventoryItemDto> getAllItems() {
        return repository.findAll().stream()
                .map(v -> mapper.mapToItemDto(v))
                .collect(Collectors.toList());
    }
}
