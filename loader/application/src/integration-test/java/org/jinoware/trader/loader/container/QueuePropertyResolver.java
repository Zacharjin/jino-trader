package org.jinoware.trader.loader.container;

import org.jinoware.trader.loader.BaseIntegrationTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.support.TestPropertySourceUtils;

public class QueuePropertyResolver implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext context) {

        CustomMongoDbContainer container = BaseIntegrationTest.mongoDBContainer;
        Integer port = container.getMappedPort(CustomMongoDbContainer.MONGO_PORT);
        overrideProperty(context, "spring.datasource.url", "mongodb://localhost:"+port);
        overrideProperty(context, "spring.datasource.database", CustomMongoDbContainer.DB);
        overrideProperty(context, "spring.datasource.username", CustomMongoDbContainer.USERNAME);
        overrideProperty(context, "spring.datasource.password", CustomMongoDbContainer.PASSWORD);
    }

    private void overrideProperty(ConfigurableApplicationContext context, String prop, String val) {
        TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
                context, prop+"="+val);
    }


}
