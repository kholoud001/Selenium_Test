package test.springformselenium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringFormSeleniumApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFormSeleniumApplication.class, args);
    }

}
