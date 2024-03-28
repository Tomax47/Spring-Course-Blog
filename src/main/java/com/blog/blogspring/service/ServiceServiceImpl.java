package com.blog.blogspring.service;

import com.blog.blogspring.dto.ServiceDto;
import com.blog.blogspring.dto.ServiceForm;
import com.blog.blogspring.model.Service;
import com.blog.blogspring.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceServiceImpl implements ServiceService{

    @Autowired
    private ServiceRepo serviceRepo;

    @Override
    public ServiceDto addService(ServiceForm serviceForm) {
        Service service = Service.builder()
                .name(serviceForm.getName())
                .cost(serviceForm.getCost())
                .date(serviceForm.getDate())
                .build();

        serviceRepo.save(service);
        return ServiceDto.of(service);
    }

    @Override
    public List<ServiceDto> search(Integer page, Integer size, String query, String sortParameter, String directionParameter) {
        Sort.Direction direction = Sort.Direction.ASC;
        Sort sort = Sort.by(direction, "id");

        if (directionParameter != null) {
            direction = Sort.Direction.fromString(directionParameter);
        }

        if (sortParameter != null) {
            sort = Sort.by(direction, sortParameter);
        }

        if (query == null) {
            // empty, tells sql that the query is empty "instead of null that aint suit the sql"
            query = "empty";
        }

        if (size == null) {
            size = 3;
        }

        // The pageRequest here has the crucial data from the user to perform the search request
        // Params of the page to search for
        PageRequest pageRequest = PageRequest.of(page, size, sort);

        // The page itself that we are looking for that holds the data we wanted to search it
        Page<Service> papersPage = serviceRepo.search(query, pageRequest);

        return ServiceDto.from(papersPage.getContent());
    }
}
