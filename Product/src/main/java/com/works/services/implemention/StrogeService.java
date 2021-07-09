package com.works.services.implemention;

import com.works.models.dtos.StorageDto;
import com.works.models.entities.models.Stroge;
import com.works.repostories.IStrogeRepostories;
import com.works.services.abstracts.IStrogeService;
import com.works.utils.Result;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StrogeService implements IStrogeService {

    IStrogeRepostories iStrogeRepostories;
    ModelMapper modelMapper;

    public StrogeService(IStrogeRepostories iStrogeRepostories, ModelMapper modelMapper) {
        this.iStrogeRepostories = iStrogeRepostories;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result<StorageDto> Save(StorageDto storageDto) {
        return new Result<>(true,"kaydedildi",modelMapper.map(iStrogeRepostories.save(modelMapper.map(storageDto, Stroge.class)), StorageDto.class));
    }

    @Override
    public Result<StorageDto> Update(StorageDto storageDto) {
        return new Result<>(true,"kaydedildi",modelMapper.map(iStrogeRepostories.saveAndFlush(modelMapper.map(storageDto, Stroge.class)), StorageDto.class));
    }

    @Override
    public Result<StorageDto> getById(int id) {
        return new Result<>(true,"güncellendi",modelMapper.map(iStrogeRepostories.getById(id), StorageDto.class));
    }

    @Override
    public Result<List<StorageDto>> getAll() {
        return new Result<>(true,"bütün depolar", Arrays.asList(modelMapper.map(iStrogeRepostories.findAll(),StorageDto[].class)));
    }
}
