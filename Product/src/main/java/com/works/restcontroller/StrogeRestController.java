package com.works.restcontroller;

import com.works.models.dtos.StorageDto;
import com.works.services.abstracts.IStrogeService;
import com.works.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/stroge")
public class StrogeRestController {

    IStrogeService istrogeService;

    public StrogeRestController(IStrogeService istrogeService) {
        this.istrogeService = istrogeService;
    }

    @PostMapping("/save")
    public Result<StorageDto> save(@RequestBody StorageDto storage){
       Result result= istrogeService.Save(storage);
        return result;
    }

    @GetMapping("/getById/{id}")
    public Result<StorageDto> getById(@PathVariable(value="id")  int id){
        Result result= istrogeService.getById(id);
        return result;
    }

    @GetMapping("/getAll")
    public Result<StorageDto> getAll(){
        Result result= istrogeService.getAll();
        return result;
    }

    @PostMapping("/update")
    public Result<StorageDto> update(@RequestBody StorageDto storage){
        Result result= istrogeService.Update(storage);
        return result;
    }
}
