package dev.bug.api.data.mos.services;

import java.util.List;

public interface Service<T> {

    List<T> getAll();

    T getOneById(Long id);

    T save(T app);

    T update(Long id, T app);

    void delete(Long id);

    void clean();
}
