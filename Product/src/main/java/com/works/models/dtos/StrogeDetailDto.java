package com.works.models.dtos;

import com.works.models.entities.Product;
import com.works.models.entities.Stroge;
import com.works.models.entities.StrogeAction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrogeDetailDto extends BaseDto{

    private String code;
    private float miktar;
    private boolean active;
    private float doluluk;

    private Product product;
    private Stroge stroge;
    private List<StrogeAction> strogeActionList;

}
