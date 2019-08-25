package dev.bug.api.data.mos.services.app;

import dev.bug.api.data.mos.exceptions.AppAlreadyExistsException;
import dev.bug.api.data.mos.exceptions.AppNotExistsException;
import dev.bug.api.data.mos.model.App;
import dev.bug.api.data.mos.repositories.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public App update(Long id, App updatingForApp) {
        final App newApp = getExistingApp(id);
        newApp.setCaption(updatingForApp.getCaption());
        newApp.setCategory(updatingForApp.getCategory());
        newApp.setDescription(updatingForApp.getDescription());
        newApp.setDeveloper(updatingForApp.getDeveloper());
        newApp.setPublishDate(updatingForApp.getPublishDate());
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
