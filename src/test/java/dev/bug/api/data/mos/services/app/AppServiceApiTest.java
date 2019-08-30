package dev.bug.api.data.mos.services.app;

import dev.bug.api.data.mos.model.AppRest;
import dev.bug.api.data.mos.services.ServiceApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppServiceApiTest {

    @Autowired
    ServiceApi serviceApi;

    @Test
    public void getAppItems() {
        final AppRest[] items = serviceApi.getItems(AppRest[].class, "apps");
        System.out.println(Arrays.toString(items));
    }
}