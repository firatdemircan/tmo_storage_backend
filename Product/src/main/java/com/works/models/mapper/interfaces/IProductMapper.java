package com.works.models.mapper.interfaces;

import com.works.models.dtos.ProductDto;
import com.works.models.entities.models.Product;

import java.util.List;

public interface IProductMapper {

    ProductDto productToProductDto(Product product);
    Product productToProductDto(ProductDto product);

    List<Product> listProductDtoToProduct(List<ProductDto> productDto);
    List<ProductDto> listProductToProductDto(List<Product> product);

}
