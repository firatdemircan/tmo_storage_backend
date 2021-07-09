package com.works.services.implemention;

import com.works.models.dtos.StrogeActionDto;
import com.works.repostories.IStrogeActionRepostories;
import com.works.services.abstracts.IStrogeActionService;
import com.works.utils.Result;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class StrogeActionService implements IStrogeActionService {


    IStrogeActionRepostories iStrogeActionRepostories;
    ModelMapper mapper;

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
        return new Result<StrogeActionDto>(true,"depoya göre getirildi", mapper.map(iStrogeActionRepostories.getById(id),StrogeActionDto.class)) ;
    }

    @Override
    public Result<List<StrogeActionDto>> getAll() {
        return new Result<List<StrogeActionDto>>(true,"getirildi", Arrays.asList(mapper.map(iStrogeActionRepostories.findAll(),StrogeActionDto[].class))) ;
    }

    @Override
    public Result<List<StrogeActionDto>> getByStrogeDetail(int id) {
        return new Result<List<StrogeActionDto>>(true,"depoya göre getirildi", Arrays.asList(mapper.map(iStrogeActionRepostories.getAllByStrogeDetailId(id),StrogeActionDto[].class))) ;
    }
}
