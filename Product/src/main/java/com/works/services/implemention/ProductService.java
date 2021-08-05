package com.works.services.implemention;

import com.works.models.dtos.ProductDto;
import com.works.models.entities.Product;
import com.works.repostories.IProductRepostories;
import com.works.services.abstracts.IProductService;
import com.works.utils.Result;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService implements IProductService {

    IProductRepostories iProductRepostories;
    ModelMapper modelMapper;

    public ProductService(IProductRepostories iProductRepostories,ModelMapper modelMapper) {
        this.iProductRepostories = iProductRepostories;
        this.modelMapper = modelMapper;
    }

//specifications


//specifications

    @Override
    public Result<ProductDto> Save(ProductDto productDto) {
        /*
            TODO : using specifitaions


        List<Product> products = iProductRepostories.findAll(new Specification<Product>(){
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder){

                Predicate p = criteriaBuilder.conjunction();


                return null;
            }
        });
   */



        return new Result<>(true,"kaydedildi",modelMapper.map(iProductRepostories.save(modelMapper.map(productDto,Product.class)),ProductDto.class));
    }

    @Override
    public Result<ProductDto> Update(ProductDto productDto) {
        return new Result<>(true,"güncellendi",modelMapper.map(iProductRepostories.saveAndFlush(modelMapper.map(productDto, Product.class)),ProductDto.class));
    }

    @Override
    public Result<ProductDto> getById(int id) {
        return new Result<>(true,"getirildi",modelMapper.map(iProductRepostories.getById(id),ProductDto.class));
    }

    @Override
    public Result<List<ProductDto>> getAll() {
        return new Result<>(true,"liste getirildi", Arrays.asList(modelMapper.map(iProductRepostories.findAll(),ProductDto[].class)));
    }
}
