package com.example.maalm.controller;

import com.example.maalm.entities.Service;
import com.example.maalm.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class ServiceController  {
    private  final ServiceService serviceService;
    @GetMapping("/{id}")
    public Service getService(@PathVariable Long id) {
        return serviceService.getService(id);
    }
    @GetMapping
    public List<Service> getALLServices(){
        return  serviceService.getAllServices();
    }
   @DeleteMapping("{id}")
   public void deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
   }
   @PutMapping
   public Service update(@RequestBody Service service) {
        return serviceService.update(service);
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
