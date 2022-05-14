package org.jinoware.trader.loader.container;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

public class CustomMongoDbContainer extends GenericContainer {
    static final String USERNAME = "username";
    static final String PASSWORD = "password";
    static final String DB = "admin";

    static final int MONGO_PORT = 27017;

    public CustomMongoDbContainer() {
        super(DockerImageName.parse("mongo:4.0.10"));
        withEnv("MONGO_INITDB_ROOT_USERNAME", USERNAME);
        withEnv("MONGO_INITDB_ROOT_PASSWORD", PASSWORD);
        withEnv("MONGO_INITDB_DATABASE", DB)
                .withExposedPorts(MONGO_PORT);
    }
}
