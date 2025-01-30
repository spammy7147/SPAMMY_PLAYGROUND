package hello;

import hello.config.MyDataSourceConfigV1;
import hello.config.MyDataSourceEnvConfig;
import hello.config.MyDataValueConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Import;


//@Import(MyDataSourceEnvConfig.class)
@Import(MyDataSourceConfigV1.class)
@SpringBootApplication(scanBasePackages = "hello.datasource")
@ConfigurationPropertiesScan({"hello"})
public class ExternalReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalReadApplication.class, args);
    }

}
