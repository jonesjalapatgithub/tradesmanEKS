package com.jonesjalapat.blog.tradesman.config;

import javax.sql.DataSource;
import liquibase.integration.spring.SpringLiquibase;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class LiquibaseConfiguration {
  private final DataSource dataSource;

  @Bean
  public SpringLiquibase liquibase() {
    SpringLiquibase liquibase = new SpringLiquibase();
    liquibase.setChangeLog("classpath:db/changelog/master.xml");
    liquibase.setDataSource(dataSource);
    return liquibase;
  }
}
