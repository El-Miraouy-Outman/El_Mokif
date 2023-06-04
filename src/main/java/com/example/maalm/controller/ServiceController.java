package com.example.maalm.controller;

import com.example.maalm.entities.Service;
import com.example.maalm.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
@CrossOrigin(origins = "*")
public class ServiceController  {
    private  final ServiceService serviceService;
    @GetMapping("/{id}")
    public Service getService(@PathVariable Long id) {
        return serviceService.getService(id);
    }

    @GetMapping("/name/{name}")
    public Service getServiceByName(@PathVariable String name) {
        return serviceService.getServiceByName(name);
    }

    @PostMapping
    public Service insert(@RequestBody Service service) {
        return serviceService.insert(service);
    }
}
