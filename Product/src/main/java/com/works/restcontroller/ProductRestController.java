package com.works.restcontroller;

import com.works.models.dtos.ProductDto;
import com.works.services.abstracts.IProductService;
import com.works.utils.Result;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductRestController {

    IProductService iproductService;

    public ProductRestController(IProductService iproductService) {
        this.iproductService = iproductService;
    }

    @PostMapping("/save")
    public Result<ProductDto> save(@RequestBody  ProductDto productDto){
        Result result= iproductService.Save(productDto);
        return result;
    }

    @GetMapping("/getById/{id}")
    public Result<ProductDto> getById(@PathVariable(value="id") int id){
        Result result= iproductService.getById(id);
        return result;
    }

    @GetMapping("/getAll")
    public Result<ProductDto> getAll(){
        Result result= iproductService.getAll();
        return result;
    }

    @PostMapping("/update")
    public Result<ProductDto> update(@RequestBody ProductDto productDto){
        Result result= iproductService.Update(productDto);
        return result;
    }
}
