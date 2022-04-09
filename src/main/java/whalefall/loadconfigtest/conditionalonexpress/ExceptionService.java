package whalefall.loadconfigtest.conditionalonexpress;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class ExceptionService extends NormalService {
    @Value("${express.goException:false}")
    private boolean goException;

    @Override
    public String test() {

        if (this.goException)
            return "exception service goException";
        else
            return "exception service goNormal";
    }
}
