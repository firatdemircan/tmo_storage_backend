package com.works.services.implemention;

import com.works.models.dtos.StrogeActionDto;
import com.works.services.abstracts.IStrogeActionService;
import com.works.utils.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrogeActionService implements IStrogeActionService {
    @Override
    public Result<StrogeActionDto> Save(StrogeActionDto strogeActionDto) {
        return null;
    }

    @Override
    public Result<StrogeActionDto> Update(StrogeActionDto strogeActionDto) {
        return null;
    }

    @Override
    public Result<StrogeActionDto> getById(int id) {
        return null;
    }

    @Override
    public Result<List<StrogeActionDto>> getAll() {
        return null;
    }
}
