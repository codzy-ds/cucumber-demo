package org.hamsterlabs.cucumber_demo.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.hamsterlabs.cucumber_demo.CucumberDemoApplication;
import org.hamsterlabs.cucumber_demo.FortuneCookieBackendApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.MariaDBContainer;

@CucumberContextConfiguration
@SpringBootTest(classes = CucumberDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ComponentScan(basePackages = "org.hamsterlabs.cucumber_demo.entities")
public class BddConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public FortuneCookieBackendApplication fortuneCookieBackendApplication(MariaDBContainer<?> database) {
        new SpringApplicationBuilder(CucumberDemoApplication.class)
                .properties("spring.datasource.url=" + database.getJdbcUrl())
                .properties("spring.datasource.username=" + database.getUsername())
                .properties("spring.datasource.password=" + database.getPassword())
                .properties("spring.jpa.hibernate.ddl-auto=update")
                .run();

        return new SpringApplicationBuilder(FortuneCookieBackendApplication.class)
                .properties("server.port=8081")
                .properties("spring.datasource.url=" + database.getJdbcUrl())
                .properties("spring.datasource.username=" + database.getUsername())
                .properties("spring.datasource.password=" + database.getPassword())
                .properties("spring.jpa.hibernate.ddl-auto=update")
                .properties("hibernate.dialect=org.hibernate.dialect.MariaDBDialect")
                .run()
                .getBean(FortuneCookieBackendApplication.class);

    }

    @Bean
    public MariaDBContainer<?> database() {
        MariaDBContainer<?> mySQLContainer = new MariaDBContainer<>("mariadb:10.6.4")
                .withDatabaseName("testdb")
                .withUsername("test")
                .withPassword("test");
        mySQLContainer.start();
        return mySQLContainer;
    }
}
