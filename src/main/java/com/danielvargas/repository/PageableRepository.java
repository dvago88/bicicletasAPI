package com.danielvargas.repository;

import com.danielvargas.entity.DataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageableRepository extends PagingAndSortingRepository<DataEntity, Long> {

    Page<DataEntity> findAll();
}