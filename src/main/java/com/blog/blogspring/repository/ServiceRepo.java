package com.blog.blogspring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.blog.blogspring.model.Service;

public interface ServiceRepo extends JpaRepository<Service, Long> {

    // The pageable sends info on the page, the size, and the sort "PageRequest"
    @Query("SELECT service FROM Service service WHERE (:q = 'empty' OR UPPER(service.name) LIKE UPPER(concat('%', :q, '%'))) ")
    Page<Service> search(@Param("q") String q, Pageable pageable);
}
