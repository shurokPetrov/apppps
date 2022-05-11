package catalog.util.mapper;

import catalog.data.CatalogDto;
import catalog.entity.Catalog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Mapper
@Service
public interface CatalogMapper {
    @Mapping(source="listPrice", target="listPrice", qualifiedByName="StringToBigDecimal")
    @Mapping(source="salePrice", target="salePrice", qualifiedByName="StringToBigDecimal")
    CatalogDto mapToDto(Catalog catalog);

    @Named("StringToBigDecimal")
    default BigDecimal convertToBigDecimal(String value) {
        return value == null? BigDecimal.ZERO : new BigDecimal(value);
    }
}
