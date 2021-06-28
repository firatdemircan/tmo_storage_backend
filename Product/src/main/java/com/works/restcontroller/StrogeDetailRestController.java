package com.works.restcontroller;

import com.works.models.dtos.StrogeDetailDto;
import com.works.services.abstracts.IStrogeDetailService;
import com.works.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/strogedetail")
public class StrogeDetailRestController {

    IStrogeDetailService istrogeDetailService;

    public StrogeDetailRestController(IStrogeDetailService istrogeDetailService) {
        this.istrogeDetailService = istrogeDetailService;
    }

    @PostMapping("/save")
    public Result<StrogeDetailDto> save(@RequestBody StrogeDetailDto strogeDetailDto){
        strogeDetailDto.setDoluluk(0.0f);
        Result result= istrogeDetailService.Save(strogeDetailDto);
        return result;
    }

    @GetMapping("/getById/{id}")
    public Result<StrogeDetailDto> getById(@PathVariable(value="id") int id){
        Result result= istrogeDetailService.getById(id);
        return result;
    }

    @GetMapping("/getAll")
    public Result<StrogeDetailDto> getAll(){
        Result result= istrogeDetailService.getAll();
        return result;
    }

    @PostMapping("/update")
    public Result<StrogeDetailDto> update(@RequestBody StrogeDetailDto strogeDetailDto){
        Result result= istrogeDetailService.Update(strogeDetailDto);
        return result;
    }

    @PostMapping("/close/{id}")
    public Result<StrogeDetailDto> close(@PathVariable(value="id") int id){
        Result result= istrogeDetailService.closeStrogeDetail(id);
        return result;
    }

    @PostMapping("/satis/{id}/{miktar}")
    public Result<StrogeDetailDto> UrunSatis(@PathVariable(value="id") int id,float miktar){
        Result result= istrogeDetailService.closeStrogeDetail(id);
        return result;
    }

    @PostMapping("/close/{id}/{miktar}")
    public Result<StrogeDetailDto> UrunAlim(@PathVariable(value="id") int id,float miktar){
        Result result= istrogeDetailService.closeStrogeDetail(id);
        return result;
    }

    @PostMapping("/close/{sevkId}/{tesellumId}/{miktar}")
    public Result<StrogeDetailDto> UrunSevk(@PathVariable(value="id") int sevkId,int tesellumId,float miktar){
        return null;
    }

}
