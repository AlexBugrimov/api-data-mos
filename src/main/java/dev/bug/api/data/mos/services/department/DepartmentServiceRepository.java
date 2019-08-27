package dev.bug.api.data.mos.services.department;

import dev.bug.api.data.mos.exceptions.DepartmentAlreadyExistsException;
import dev.bug.api.data.mos.exceptions.DepartmentNotExistsException;
import dev.bug.api.data.mos.model.Department;
import dev.bug.api.data.mos.repositories.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceRepository implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getOneById(Long id) {
        return departmentRepository
                .findById(id)
                .orElseThrow(DepartmentNotExistsException::new);
    }

    @Override
    public Department save(Department department) {
        final Department savedDepartment = department.getDepartmentId() == null
                ? department : getExistingDepartment(department.getDepartmentId());
        return departmentRepository.save(savedDepartment);
    }

    @Override
    public Department update(Long id, Department newDepartment) {
        final Department oldDepartment = getExistingDepartment(id);
        BeanUtils.copyProperties(newDepartment, oldDepartment, "departmentId");
        return departmentRepository.save(newDepartment);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(getExistingDepartment(id).getDepartmentId());
    }

    @Override
    public void clean() {
        departmentRepository.deleteAll();
    }

    private Department getExistingDepartment(Long id) {
        return departmentRepository.findById(id).orElseThrow(DepartmentAlreadyExistsException::new);
    }
}
