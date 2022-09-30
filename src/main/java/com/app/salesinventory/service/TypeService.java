package com.app.salesinventory.service;

import com.app.salesinventory.exception.TypeIdNotFoundException;
import com.app.salesinventory.model.Type;
import com.app.salesinventory.model.repository.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> findAllType() {
        return typeRepository.findAll();
    }

    public Type addType(Type type){
        return typeRepository.save(type);
    }
    public Type updateType(Type type) {
        return typeRepository.save(type);
    }
    public Type findTypeById(Long id){
        return typeRepository.findTypeById(id).orElseThrow(()-> new TypeIdNotFoundException("Type with id " + id + " was not found")).getType();
    }

    public void deleteTypeById(Long id) {
        typeRepository.deleteTypeById(id);
    }
}
