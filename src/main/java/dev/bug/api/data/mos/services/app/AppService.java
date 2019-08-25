package dev.bug.api.data.mos.services.app;

import dev.bug.api.data.mos.model.App;

import java.util.List;

public interface AppService {

    List<App> getAll();

    App getOneById(Long id);

    App save(App app);

    App update(Long id, App app);

    void delete(Long id);

    void clean();
}
