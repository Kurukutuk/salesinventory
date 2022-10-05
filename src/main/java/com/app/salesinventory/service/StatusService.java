package com.app.salesinventory.service;

import com.app.salesinventory.exception.StockNotFoundException;
import com.app.salesinventory.model.Order;
import com.app.salesinventory.model.Status;
import com.app.salesinventory.repository.OrderRepository;
import com.app.salesinventory.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> findAllStatus() {
        return statusRepository.findAll();
    }
    public Status addNewStatus(Status status) {
        Optional<Status> statusOptional = statusRepository.findStatusById(status.getId());
        if (statusOptional.isPresent()){
            throw new IllegalStateException("Status already added before!");
        }
        return statusRepository.save(status);
    }
    public Status updateStatus(Status status){
        return statusRepository.save(status);
    }
    public Status findStatusById(Long id) {
        return statusRepository.findStatusById(id).orElseThrow(()-> new StockNotFoundException("Status by id " + id + " was not found"));
    }
    public void deleteStatus(Long id){
        statusRepository.deleteStatusById(id);
    }
}
