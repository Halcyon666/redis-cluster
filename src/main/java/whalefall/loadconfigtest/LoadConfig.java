package whalefall.loadconfigtest;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: WhaleFall541
 * @date: 2021/11/23 21:58
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "my.test")
@PropertySource(value = {"classpath:test.properties"})
public class LoadConfig {
    private String A;

    private String B;
}
