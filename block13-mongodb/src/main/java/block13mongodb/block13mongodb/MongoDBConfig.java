package block13mongodb.block13mongodb;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@Configuration
@EnableMongoRepositories(basePackages = "com.concretepage.repository")
public class MongoDBConfig {
    public String getDatabaseName() {
        return "myMongoDB";
    }
    @Bean
    public MongoClient mongoClient() {
        ServerAddress address = new ServerAddress("127.0.0.1", 27017);
        MongoCredential credential = MongoCredential.createCredential("mdbUser", getDatabaseName(), "cp".toCharArray());
        MongoClientOptions options = new MongoClientOptions.Builder().build();

        MongoClient client = new MongoClient(address, credential, options);
        return client;
    }
    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory() {
        MongoDatabaseFactory factory = new SimpleMongoClientDatabaseFactory((com.mongodb.client.MongoClient) mongoClient(), getDatabaseName());
        return factory;
    }
    @Bean
    public MongoTemplate mongoTemplate() {
        MongoTemplate template = new MongoTemplate(mongoDatabaseFactory());
        return template;
    }
}

