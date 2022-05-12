package product.util.mapper;

import org.mapstruct.Mapper;
import product.data.CatalogDto;
import product.data.ProductResponseDto;

@Mapper
public interface ProductMapper {
    ProductResponseDto mapToProductResponseDto(CatalogDto dto);
}
