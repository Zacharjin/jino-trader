package org.jinoware.trader.loader;

import org.jinoware.trader.loader.container.CustomMongoDbContainer;
import org.jinoware.trader.loader.container.CustomRabbitMQContainer;
import org.jinoware.trader.loader.container.DatabasePropertyResolver;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = Application.class)
@ContextConfiguration(initializers = DatabasePropertyResolver.class)
@ActiveProfiles("integration")
public class BaseIntegrationTest {

	public static CustomMongoDbContainer mongoDBContainer = new CustomMongoDbContainer();
	public static CustomRabbitMQContainer rabbitMQContainer = new CustomRabbitMQContainer();

	@BeforeAll
	public static void setup(){
		mongoDBContainer.start();
		rabbitMQContainer.start();
	}

}
