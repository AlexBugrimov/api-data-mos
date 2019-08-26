package dev.bug.api.data.mos.services.app;

import dev.bug.api.data.mos.exceptions.AppAlreadyExistsException;
import dev.bug.api.data.mos.exceptions.AppNotExistsException;
import dev.bug.api.data.mos.model.App;
import dev.bug.api.data.mos.repositories.AppRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceRepository implements AppService {

    private final AppRepository appRepository;

    @Autowired
    public AppServiceRepository(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    @Override
    public List<App> getAll() {
        return appRepository.findAll();
    }

    @Override
    public App getOneById(Long id) {
        return appRepository
                .findById(id)
                .orElseThrow(AppNotExistsException::new);
    }

    @Override
    public App save(App app) {
        final App savedApp = app.getAppId() == null ? app : getExistingApp(app.getAppId());
        return appRepository.save(savedApp);
    }

    @Override
    public App update(Long id, App newApp) {
        final App oldApp = getExistingApp(id);
        BeanUtils.copyProperties(newApp, oldApp, "appId");
        return appRepository.save(newApp);
    }

    @Override
    public void delete(Long id) {
        appRepository.deleteById(getExistingApp(id).getAppId());
    }

    @Override
    public void clean() {
        appRepository.deleteAll();
    }

    private App getExistingApp(Long id) {
        return appRepository.findById(id).orElseThrow(AppAlreadyExistsException::new);
    }
}
