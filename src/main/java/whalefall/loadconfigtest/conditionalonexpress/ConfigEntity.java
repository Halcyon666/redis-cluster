package whalefall.loadconfigtest.conditionalonexpress;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("express")
@Data
public class ConfigEntity {
    // 注意注入的属性不要以is开头 否则注入失败
    private boolean isSwitchExceptionClass;
    private boolean switchFlag;
    private boolean goException;
}
