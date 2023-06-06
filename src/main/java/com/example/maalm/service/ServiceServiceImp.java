package com.example.maalm.service;

import com.example.maalm.entities.Service;
import com.example.maalm.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor

public class ServiceServiceImp implements ServiceService{
    private final ServiceRepository serviceRepository;

    @Override
    public Service getService(Long id) {
        return serviceRepository.findById(id).get();
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Service getServiceByName(String name) {
        return serviceRepository.findByName(name);
    }

    @Override
    public Service insert(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public Service update(Service service) {
        Service service1=serviceRepository.findById(service.getId()).get();
        service1.setName(service.getName());
        return serviceRepository.save(service1);
    }
}
