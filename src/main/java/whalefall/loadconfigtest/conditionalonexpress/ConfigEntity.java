package whalefall.loadconfigtest.conditionalonexpress;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
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
    /*
    //两位大写 yml配置项大小写不敏感 ,以下都可以成功注入
    express.goGoException: true
    express.gogoException: true
    express.go-go-exception: true
     */
    private boolean goGoException;
    private boolean goexceptions;//全小写
    @Value("${express.ceShi: false}")
    private boolean ceShi;//全小写
}
