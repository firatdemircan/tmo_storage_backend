package com.works.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseDto{

    @NotNull
    private String productName;
    private String productCode;

    private List<StrogeDetailDto> strogeDetailList;

}
