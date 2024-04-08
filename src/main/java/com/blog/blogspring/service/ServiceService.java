package com.blog.blogspring.service;

import com.blog.blogspring.dto.ServiceDto;
import com.blog.blogspring.dto.ServiceForm;

import java.util.List;

public interface ServiceService {
    ServiceDto addService(ServiceForm serviceForm);
    List<ServiceDto> search(Integer size, Integer page, String query, String sort, String direction);

    List<ServiceDto> getAllServices();
}
