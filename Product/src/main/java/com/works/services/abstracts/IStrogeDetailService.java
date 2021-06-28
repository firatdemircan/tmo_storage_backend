package com.works.services.abstracts;

import com.works.models.dtos.StrogeDetailDto;
import com.works.services.IBaseService;
import com.works.utils.Result;

public interface IStrogeDetailService extends IBaseService<StrogeDetailDto> {
    Result closeStrogeDetail(int id);

    Result strogeSatis(int id,float miktar);

    Result strogeAlim(int id, float miktar);

    Result strogeSevk(int sevkId,int TesellumId, float miktar);
}
