package com.microservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
  "spring.datasource.url=jdbc:h2:mem:testdb",
  "spring.datasource.driver-class-name=org.h2.Driver",
  "spring.datasource.username=sa",
  "spring.datasource.password=",
  "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
  "spring.jpa.hibernate.ddl-auto=create-drop"
})
class MicroserviceProductApplicationTests {

    @Test
    void contextLoads() {
    }
}
