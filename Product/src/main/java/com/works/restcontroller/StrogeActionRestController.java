package com.works.restcontroller;

import com.works.models.dtos.StrogeActionDto;
import com.works.services.abstracts.IStrogeActionService;
import com.works.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/storageAction")
public class StrogeActionRestController {

    @Autowired
    IStrogeActionService iStrogeActionService;
    /*
    TODO : Burada sadece görüntüleme işlemi yapılabilecek
     */

    @GetMapping("/getById/{id}")
    public Result<StrogeActionDto> getById(int id){
        return iStrogeActionService.getById(id);
    }

    @GetMapping("/getAll")
    public Result<List<StrogeActionDto>> getAll(){
        return iStrogeActionService.getAll();
    }

    @GetMapping("/getByStorageDetail/{id}")
    public Result<List<StrogeActionDto>> getByStorageDetail(int id){
        return iStrogeActionService.getByStrogeDetail(id);
    }

}
