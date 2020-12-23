package ru.geekbrains.lesson.store;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("ru.geekbrains.lesson.store.repositories")
@EnableTransactionManagement
@ComponentScan("ru.geekbrains.lesson.store")
public class AppConfig {

}
