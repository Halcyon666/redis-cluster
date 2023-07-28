package whalefall.filedownloadorup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import whalefall.loadconfigtest.loadconfigfrompropfile.LoadConfig;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author: WhaleFall541
 * @date: 2021/11/25 22:29
 */
@RestController
@Slf4j
public class Test4HtmlController {

    private LoadConfig loadConfig;

    public Test4HtmlController(LoadConfig loadConfig) {
        this.loadConfig = loadConfig;
    }
    @GetMapping("testconfig")
    public String testConfig() {
        return loadConfig.getA() + "@@" + loadConfig.getB();
    }

    @PostMapping("upload")
    public String upload(@RequestParam MultipartFile file) {
        log.info(file.getOriginalFilename());

        return "OK";
    }

    @PostMapping("upload1")
    public String upload1(@RequestParam("file") MultipartFile file, @RequestParam("test") String test) {
        log.info("upload1 {} test {}", file.getOriginalFilename(), test);
        return "OK";
    }

    @PostMapping("download")
    public void downLoadFile(HttpServletResponse response) {
        String fileDownName = "价格表-模板.xlsx";
        log.debug("下载模板文件名称：" + fileDownName);
        try {
            InputStream fis = Test4HtmlController.class.getResourceAsStream("/exceltemplet/priceListTemplate.xlsx");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            response.reset();//清空response中所有的数据
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.addHeader("Content-Disposition", "attachment; filename=" +
                    URLEncoder.encode(fileDownName, "utf-8"));
            response.getOutputStream().write(buffer);
        } catch (Exception e) {
            log.debug("下载价格表-模板文件报错" , e);
        }
    }

}
