package com.app.salesinventory.controller;

import com.app.salesinventory.model.Stock;
import com.app.salesinventory.model.Type;
import com.app.salesinventory.service.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/types")
public class TypeController {

    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Type>> getAllTypes(){
        List<Type> types = typeService.findAllType();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Type> getTypeById(@PathVariable("id") Long id){
        Type type = typeService.findTypeById(id);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Type> addType(@RequestBody Type type){
        Type newType = typeService.addType(type);
        return new ResponseEntity<>(newType, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Type> updateType(@RequestBody Type type){
        Type updatedType = typeService.updateType(type);
        return new ResponseEntity<>(updatedType, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTypeById(@PathVariable("id") Long id){
        typeService.deleteTypeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
