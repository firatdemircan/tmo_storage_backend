package com.works.models.dtos;

import com.works.models.entities.StrogeDetail;
import com.works.models.enums.IslemTipi;
import lombok.*;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrogeActionDto extends BaseDto {
    private float miktar;
    private IslemTipi islemTipi;

    private StrogeDetailDto strogeDetailDto;


}
