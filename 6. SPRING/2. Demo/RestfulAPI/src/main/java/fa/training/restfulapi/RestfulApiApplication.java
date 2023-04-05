package fa.training.restfulapi;

import javax.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;
import com.fasterxml.jackson.databind.ObjectMapper;

import fa.training.restfulapi.cache.Cache;
import fa.training.restfulapi.cache.RedisCache;
import fa.training.restfulapi.storage.StorageService;
import fa.training.restfulapi.validators.GroupValidator;
import fa.training.restfulapi.validators.OrderValidator;
import fa.training.restfulapi.validators.ProductValidator;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class RestfulApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestfulApiApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.init();
		};
	}

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Bean
	public SessionFactory sessionFactory() {
		return this.entityManagerFactory.unwrap(SessionFactory.class);
	}

	@Bean
	public Validator productValidator() {
		return new ProductValidator();
	}

	@Bean
	public Validator groupValidator() {
		return new GroupValidator();
	}

	@Bean
	public Validator orderValidator() {
		return new OrderValidator();
	}

	@Value("${redis.host}")
	private String redisHost;
	@Value("${redis.port}")
	private int redisPort;
	@Value("${redis.password}")
	private String redisPassword;

	@Bean
	private Jedis redisCliFactory() {
		Jedis jedis = new Jedis(redisHost, redisPort);
		jedis.auth(redisPassword);
		return jedis;
	}

	@Bean
	@Autowired
	public Cache cacheObject(ObjectMapper objectMapper) {
		return new RedisCache(objectMapper, redisCliFactory());
	}

}
