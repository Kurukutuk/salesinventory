package com.app.salesinventory.controller;

import com.app.salesinventory.model.Stock;
import com.app.salesinventory.model.Type;
import com.app.salesinventory.service.TypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/type")
public class TypeController {

    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping("/addType")
    public void registerNewStudent(@RequestBody Type type){
        typeService.addNewType(type);
    }
}
