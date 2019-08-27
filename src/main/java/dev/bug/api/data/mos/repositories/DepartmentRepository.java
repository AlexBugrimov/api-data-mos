package dev.bug.api.data.mos.repositories;

import dev.bug.api.data.mos.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

    List<Department> findAll();
}
