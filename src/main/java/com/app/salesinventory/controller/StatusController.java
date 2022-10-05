package com.app.salesinventory.controller;

import com.app.salesinventory.model.Order;
import com.app.salesinventory.model.Status;
import com.app.salesinventory.service.OrderService;
import com.app.salesinventory.service.StatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/status")
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Status>> getAllStatus(){
        List<Status> status = statusService.findAllStatus();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable("id") Long id){
        Status status = statusService.findStatusById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Status> addStatus(@RequestBody Status status){
        Status newStatus = statusService.addNewStatus(status);
        return new ResponseEntity<>(newStatus, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Status> updateStatus(@RequestBody Status status){
        Status updateStatus = statusService.updateStatus(status);
        return new ResponseEntity<>(updateStatus, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStatusById(@PathVariable("id") Long id){
        statusService.deleteStatus(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
