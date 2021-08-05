package com.works.services.implemention;

import com.works.models.dtos.StrogeActionDto;
import com.works.models.dtos.StrogeDetailDto;
import com.works.models.entities.StrogeAction;
import com.works.models.entities.StrogeDetail;
import com.works.models.entities.enums.IslemTipi;
import com.works.repostories.IStrogeActionRepostories;
import com.works.repostories.IStrogeDetailRepostories;
import com.works.repostories.IStrogeRepostories;
import com.works.services.abstracts.IStrogeDetailService;
import com.works.utils.Result;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StrogeDetailService implements IStrogeDetailService {

    IStrogeRepostories iStrogeRepostories;
    IStrogeActionRepostories iStrogeActionRepostories;
    ModelMapper modelMapper;
    IStrogeDetailRepostories iStrogeDetailRepostories;

    public StrogeDetailService(IStrogeRepostories iStrogeRepostories, ModelMapper modelMapper, IStrogeDetailRepostories iStrogeDetailRepostories) {
        this.iStrogeRepostories = iStrogeRepostories;
        this.modelMapper = modelMapper;
        this.iStrogeDetailRepostories = iStrogeDetailRepostories;
    }

    @Override
    public Result<StrogeDetailDto> Save(StrogeDetailDto strogeDetailDto) {
        StrogeDetailDto sdDto = modelMapper.map(iStrogeDetailRepostories.findByStrogeIdAndActive(strogeDetailDto.getStroge().getId(),true),StrogeDetailDto.class);
        if(sdDto.getId() == 0){
            return new Result<>(true,"kaydedildi",modelMapper.map(iStrogeDetailRepostories.save(modelMapper.map(strogeDetailDto, StrogeDetail.class)), StrogeDetailDto.class));
        }
        return new Result<>(false,"Depo açık durumda, öncelikle depoyu kapatmanız gerekmektedir.");
    }

    @Override
    public Result<StrogeDetailDto> Update(StrogeDetailDto strogeDetailDto) {

        StrogeDetail strogeDetail = iStrogeDetailRepostories.getById(strogeDetailDto.getId());

        if(strogeDetailDto.getProduct().getId() != strogeDetail.getProduct().getId()) {
            if(strogeDetail.getMiktar()>0){
                return new Result<>(false,"Depoda ürün bulunmaktadır, öncelikle depodaki ürünü boşaltmanız gerekmektedir.");
            }
        }
        else if(strogeDetailDto.getStroge().getId() != strogeDetail.getStroge().getId())
        {
            if(iStrogeDetailRepostories.findByStrogeIdAndActive(strogeDetailDto.getStroge().getId(),true).isPresent()){
                return new Result<>(false,"Aktarmak istediğiniz depo açık kullanımda, öncelikle depodaki ürünü boşaltmanız gerekmektedir.");
            }
        }
        else if(strogeDetailDto.getMiktar()!= strogeDetail.getMiktar())
        {
            return new Result<>(false,"Miktarı Değiştiremezsiniz.");
        }
        else
        {
            return new Result<>(true,"güncellendi",modelMapper.map(iStrogeDetailRepostories.saveAndFlush(modelMapper.map(strogeDetailDto, StrogeDetail.class)), StrogeDetailDto.class));
        }
        return new Result<>(false,"Depo güncellenirken bir hata oluştu.");
    }

    @Override
    public Result<StrogeDetailDto> getById(int id) {
        return new Result<>(true,"kaydedildi",modelMapper.map(iStrogeDetailRepostories.getById(id), StrogeDetailDto.class));
    }

    @Override
    public Result<List<StrogeDetailDto>> getAll() {
        return new Result<>(true,"kaydedildi", Arrays.asList(modelMapper.map(iStrogeDetailRepostories.findAll(), StrogeDetailDto[].class)));
    }

    @Override
    public Result<StrogeDetailDto> closeStrogeDetail(int id) {
        StrogeDetail strogeDetail = iStrogeDetailRepostories.getById(id);
        if(strogeDetail.getDoluluk() ==0){
            strogeDetail.setActive(false);
            iStrogeDetailRepostories.saveAndFlush(strogeDetail);
            return new Result<>(true,"İstediğiniz depo kapatıldı",modelMapper.map(strogeDetail, StrogeDetailDto.class));
        }
        else{
            return new Result<>(false,"Depoda ürün bulunmaktadır, öncelikle depodaki ürünü boşaltmanız gerekmektedir.");
        }
    }

    @Override
    public Result strogeSatis(int id,float miktar) {
        StrogeDetailDto strogeDetailDto = modelMapper.map(iStrogeDetailRepostories.getById(id),StrogeDetailDto.class);
        if(strogeDetailDto.getDoluluk()>miktar && strogeDetailDto.isActive()){
            //satış başarılı depoda ürün var demektir.
            StrogeActionDto strogeActionDto = new StrogeActionDto();
            strogeActionDto.setStrogeDetailDto(strogeDetailDto);
            strogeActionDto.setMiktar(miktar);
            strogeActionDto.setIslemTipi(IslemTipi.satis);
            iStrogeActionRepostories.save(modelMapper.map(strogeActionDto, StrogeAction.class));
            strogeDetailDto.setDoluluk(strogeDetailDto.getDoluluk()-miktar);
            iStrogeDetailRepostories.saveAndFlush(modelMapper.map(strogeDetailDto, StrogeDetail.class));
        }
        else{
            return new Result<>(false,"Depoda yeterli miktarda ürün bulunmaktadır,");
        }

        return new Result<>(false,"Belirttiğiniz depo bulunamadı");
    }

    @Override
    public Result strogeAlim(int id,float miktar) {
        StrogeDetailDto strogeDetailDto = modelMapper.map(iStrogeDetailRepostories.getById(id),StrogeDetailDto.class);
        if(strogeDetailDto.getDoluluk()+miktar<strogeDetailDto.getMiktar() && strogeDetailDto.isActive()){
            //alım başarılı depoda yer var demektir.
            StrogeActionDto strogeActionDto = new StrogeActionDto();
            strogeActionDto.setStrogeDetailDto(strogeDetailDto);
            strogeActionDto.setMiktar(miktar);
            strogeActionDto.setIslemTipi(IslemTipi.alim);
            iStrogeActionRepostories.save(modelMapper.map(strogeActionDto, StrogeAction.class));
            strogeDetailDto.setDoluluk(strogeDetailDto.getDoluluk()-miktar);
            iStrogeDetailRepostories.saveAndFlush(modelMapper.map(strogeDetailDto, StrogeDetail.class));
        }
        else{
            return new Result<>(false,"Depoda yeterli miktarda yer yoktur, başka depo seçiniz");
        }

        return new Result<>(false,"Belirttiğiniz depo bulunamadı");    }

    @Override
    public Result strogeSevk(int sevkId, int TesellumId,float miktar) {
        return null;
    }

}
