package com.carsite.carsite.mapper;

import com.carsite.carsite.dto.ProductDTO;
import com.carsite.carsite.model.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T14:50:37+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.0.2.jar, environment: Java 11.0.4 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( product.getId() );
        productDTO.setDescription( product.getDescription() );
        productDTO.setAvailableCount( product.getAvailableCount() );
        productDTO.setDiscount( product.getDiscount() );
        productDTO.setPrice( product.getPrice() );

        return productDTO;
    }
}
