package com.app.salesinventory.service;

import com.app.salesinventory.model.Stock;
import com.app.salesinventory.model.Type;
import com.app.salesinventory.model.repository.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService {
    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public void addNewType(Type type) {
        Optional<Stock> typeOptional = typeRepository.findTypeById(type.getId());
        if (typeOptional.isPresent()){
            throw new IllegalStateException("Type already added before!");
        }
        typeRepository.save(type);
    }

}
