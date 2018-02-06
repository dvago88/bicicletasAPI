package com.danielvargas.entity.data;

import com.danielvargas.entity.data.DataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageableDataRepository extends PagingAndSortingRepository<DataEntity, Long> {
    Page<DataEntity> findByCodigo(String codigo);
}
