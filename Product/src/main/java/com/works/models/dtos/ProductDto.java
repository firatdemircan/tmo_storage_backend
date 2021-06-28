package com.works.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseDto{

    private String productName;
    private String productCode;

    private List<StrogeDetailDto> strogeDetailList;

}
