package com.works.models.mapper.implementaion;

import com.works.models.dtos.ProductDto;
import com.works.models.entities.Product;
import com.works.models.mapper.interfaces.IProductMapper;

import java.util.List;

public class ProductMapper implements IProductMapper {
    @Override
    public ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductName(product.getProductName());
        return productDto;
    }

    @Override
    public Product productToProductDto(ProductDto product) {
        return null;
    }

    @Override
    public List<Product> listProductDtoToProduct(List<ProductDto> productDto) {
        return null;
    }

    @Override
    public List<ProductDto> listProductToProductDto(List<Product> product) {
        return null;
    }
}
