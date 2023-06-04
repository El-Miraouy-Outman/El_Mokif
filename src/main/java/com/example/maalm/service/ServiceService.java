package com.example.maalm.service;

import com.example.maalm.entities.Service;

public interface ServiceService {
    public Service getService(Long id);
    public Service getServiceByName(String name);
    public Service insert(Service service);
}
