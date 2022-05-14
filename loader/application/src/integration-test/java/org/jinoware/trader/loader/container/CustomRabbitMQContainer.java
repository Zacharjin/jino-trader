package org.jinoware.trader.loader.container;

import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.utility.DockerImageName;

public class CustomRabbitMQContainer extends RabbitMQContainer {
    public CustomRabbitMQContainer() {
        super("rabbitmq:3.7-management");
    }
}
