package catalog.repository;

import catalog.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog, String> {
    List<Catalog> getCatalogsBySku(String sku);
}
