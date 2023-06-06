package com.example.maalm.service;

import com.example.maalm.entities.Service;

import java.util.List;

public interface ServiceService {
    public Service getService(Long id);
    public void deleteService(Long id);

    public Service getServiceByName(String name);
    public Service insert(Service service);
    public Service update(Service service);

    List<Service> getAllServices();
}
