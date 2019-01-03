package activemq.consumera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ConsumerAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerAApplication.class, args);
    }

}

