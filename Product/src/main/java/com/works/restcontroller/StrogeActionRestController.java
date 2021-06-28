package com.works.restcontroller;

import com.works.services.abstracts.IStrogeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StrogeActionRestController {

    @Autowired
    IStrogeDetailService istrogeDetailService;

}
