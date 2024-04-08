package com.blog.blogspring.controller;

import com.blog.blogspring.dto.ServiceDto;
import com.blog.blogspring.dto.ServiceForm;
import com.blog.blogspring.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    //TODO: Implement /allservices /get

    @PostMapping("/services")
    @ResponseBody
    public ResponseEntity<ServiceDto> addService(@RequestBody ServiceForm serviceForm) {
        return ResponseEntity.ok(serviceService.addService(serviceForm));
    }

    @GetMapping("/services")
    public String serviceForm(Model model) {
        model.addAttribute("servicesList", serviceService.getAllServices());
        return "services";
    }

    @GetMapping("/allServices")
    @ResponseBody
    public ResponseEntity<List<ServiceDto>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    @PostMapping("/paper/service/search")
    @ResponseBody
    // The response entity is what we will return
    // The required = false, to show that it ain't necessary to have em all in the request each time
    public ResponseEntity<List<ServiceDto>> search(@RequestParam(value = "size", required = false) Integer size,
                                                   @RequestParam("page") Integer page,
                                                   @RequestParam(value = "q", required = false) String query,
                                                   @RequestParam(value = "sort", required = false) String sort,
                                                   @RequestParam(value = "direction", required = false) String direction) {

        // The page, the size of the data, the query "The query for selecting the things", sort for sorting, direction "Ascending,Desc..."
        return ResponseEntity.ok(serviceService.search(page, size, query, sort, direction));
    }

    @GetMapping("/paper/service/search")
    public String searchServicesForm() {

        return "services_search";
    }

}
