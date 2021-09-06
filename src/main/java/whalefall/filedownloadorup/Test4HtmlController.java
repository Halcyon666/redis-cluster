package whalefall.filedownloadorup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("upload")
    public String upload(@RequestParam MultipartFile file) {
        log.info(file.getOriginalFilename());
        return "OK";
    }

    @PostMapping("upload1")
    public String upload1(@RequestParam MultipartFile file) {
        log.info("upload1" + file.getOriginalFilename());
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
