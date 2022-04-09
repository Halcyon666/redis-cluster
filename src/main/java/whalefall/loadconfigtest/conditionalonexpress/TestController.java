package whalefall.loadconfigtest.conditionalonexpress;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private NormalService service;

    public TestController(NormalService service) {
        this.service = service;
    }

    @GetMapping("testSwitchConfig")
    public String test() {
        return service.test();
    }
}
