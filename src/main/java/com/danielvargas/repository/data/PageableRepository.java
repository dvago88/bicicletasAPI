package com.danielvargas.repository.data;

import com.danielvargas.entity.data.DataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageableRepository extends PagingAndSortingRepository<DataEntity, Long> {

    Page<DataEntity> findAll();
}
