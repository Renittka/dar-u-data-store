package kz.dar.university.data.store;

import kz.dar.university.data.store.repository.TaskRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableElasticsearchRepositories(basePackageClasses = TaskRepository.class)
public class DataStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataStoreApplication.class, args);
	}

}
