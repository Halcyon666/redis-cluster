package whalefall.loadconfigtest.conditionalonexpress;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Slf4j
public class SwitchConfig {
    private ConfigEntity configEntity;

    public SwitchConfig(ConfigEntity configEntity) {
        this.configEntity = configEntity;
    }

    @Bean
    // @ConditionalOnExpression("#{ ${express.isSwitchExceptionClass:false} == false}")
    // 问题1 ${express.isSwitchExceptionClass:false}注入属性没问题，
    // 但是configEntity.getIsSwitchExceptionClass打印的结果是false
    // 问题2 同一个变量名千万不要一个设置为true 一个设置为false
    // @ConditionalOnExpression("#{ ${express.switchFlag:false} == false}")
    @ConditionalOnExpression("!${express.switchFlag:false}")
    @Profile("dev")
    public NormalService normalService() {
        log.error("NormalService" + configEntity);
        return new NormalService();
    }

    @Bean
    @Profile("dev")
    @ConditionalOnExpression("${express.switchFlag:false}")
    public NormalService exceptionService() {
        log.error("ExceptionService" + configEntity);
        return new ExceptionService();
    }

    @Bean
    @Profile("default")
    public NormalService devService() {
        log.error("devService" + configEntity);
        return new NormalService();
    }
}
