package com.works.models.dtos;

import com.works.models.entities.enums.IslemTipi;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrogeActionDto extends BaseDto {
    private float miktar;
    private IslemTipi islemTipi;

    private StrogeDetailDto strogeDetailDto;


}
