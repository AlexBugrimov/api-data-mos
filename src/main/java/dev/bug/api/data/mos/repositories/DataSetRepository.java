package dev.bug.api.data.mos.repositories;

import dev.bug.api.data.mos.model.DataSet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataSetRepository extends CrudRepository<DataSet, Long> {

    List<DataSet> findAll();
}
