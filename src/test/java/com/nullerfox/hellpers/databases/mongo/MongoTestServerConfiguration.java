package com.nullerfox.hellpers.databases.mongo;

import de.bwaldvogel.mongo.MongoServer;
import de.bwaldvogel.mongo.backend.memory.MemoryBackend;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import java.net.InetSocketAddress;

@Configuration
public class MongoTestServerConfiguration {
    @Bean
    public MongoTemplate mongoTemplate(final MongoDatabaseFactory mongoDbFactory) {
        return new MongoTemplate(mongoDbFactory);
    }
    
    @Bean
    public MongoDatabaseFactory mongoDbFactory(final MongoServer mongoServer) {
        final InetSocketAddress serverAddress = mongoServer.getLocalAddress();
        return new SimpleMongoClientDatabaseFactory("mongodb://" + serverAddress.getHostName() + ":" + serverAddress.getPort() + "/player-test");
    }
    
    @Bean(destroyMethod = "shutdown")
    public MongoServer mongoServer() {
        final MongoServer mongoServer = new MongoServer(new MemoryBackend());
        mongoServer.bind();
        return mongoServer;
    }
}
