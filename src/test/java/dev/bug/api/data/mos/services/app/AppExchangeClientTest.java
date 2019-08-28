package dev.bug.api.data.mos.services.app;

import dev.bug.api.data.mos.model.AppItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppExchangeClientTest {

    @Autowired
    AppExchangeClient appExchangeClient;

    @Test
    public void getAppItems() {
        final List<AppItem> appItems = appExchangeClient.getAppItems();
        System.out.println(appItems);
    }
}