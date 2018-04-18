package com.danielvargas.repository.data;

import com.danielvargas.entity.data.DataEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DataRepository extends CrudRepository<DataEntity, Long> {
    List<DataEntity> findByRfid(String codigo);

    List<DataEntity> findByStationNumberOrderByTimeInSecondsDesc(int stationNumber);
}
