package dev.bug.api.data.mos.repositories;

import dev.bug.api.data.mos.model.App;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppRepository extends CrudRepository<App, Long> {

    List<App> findAll();

    App findByAppId(Long id);
}
