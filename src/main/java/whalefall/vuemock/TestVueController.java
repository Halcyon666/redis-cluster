package whalefall.vuemock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whalefall.vuemock.entity.Category;
import whalefall.vuemock.entity.ReturnModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@RestController
@Slf4j
public class TestVueController {
    @RequestMapping("/product/getBaseCategoryList")
    public ReturnModel getCategoryLst() {
        log.info("receive getBaseCategoryList "+ new Date(System.currentTimeMillis()));
        ArrayList ret = new ArrayList();
        ret.add(Category.getInstance());

        return new ReturnModel(ret,200);
    }

    @PostMapping("/list")
    public ReturnModel getSearchInfo() {
        log.info("receive list "+ new Date(System.currentTimeMillis()));
        ArrayList ret = new ArrayList();
        ret.add(1);
        ret.add(2);

        HashMap map = new HashMap();
        map.put("goodList",ret);
        return new ReturnModel(map,200);
    }
}
