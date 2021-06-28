package com.works.models.dtos;

import com.works.models.entities.StrogeDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageDto extends BaseDto{

    private String code;
    private float miktar;

    private List<StrogeDetail> strogeDetailList;

}
