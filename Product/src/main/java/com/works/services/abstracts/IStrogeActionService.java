package com.works.services.abstracts;

import com.works.models.dtos.StrogeActionDto;
import com.works.services.IBaseService;
import com.works.utils.Result;

import java.util.List;

public interface IStrogeActionService extends IBaseService<StrogeActionDto> {

    Result<List<StrogeActionDto>> getByStrogeDetail(int id);

}
