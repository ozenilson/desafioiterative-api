package br.com.arenacode.desafioiterative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableFeignClients
public class DesafioiterativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioiterativeApplication.class, args);
	}

	@Bean(name = "threadPoolAsyncExecutor")
	public Executor asyncExecutor() {
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(10);
		executor.initialize();
		return executor;
	}

}
