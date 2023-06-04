package com.example.maalm.service;

import com.example.maalm.entities.Service;
import com.example.maalm.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor

public class ServiceServiceImp implements ServiceService{
    private final ServiceRepository serviceRepository;

    @Override
    public Service getService(Long id) {
        return serviceRepository.findById(id).get();
    }

    @Override
    public Service getServiceByName(String name) {
        return serviceRepository.findByName(name);
    }

    @Override
    public Service insert(Service service) {
        return serviceRepository.save(service);
    }
}
