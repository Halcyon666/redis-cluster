package whalefall.filedownloadorup;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

import static whalefall.filedownloadorup.TestHttpClientUpload1.FILE_PATH;
import static whalefall.filedownloadorup.TestHttpClientUpload1.UPLOAD_URL;

/**
 * @author Halcyon
 * @since 1.0.0
 */
public class TestRestTemplateUpload {
    private static final Logger logger = LoggerFactory.getLogger(TestHttpClientUpload1.class);
    @Test
    public void testResttemplateUpload() {
        File file = new File(FILE_PATH);

        // 创建RestTemplate实例
        RestTemplate restTemplate = new RestTemplate();

        // 构建请求体
        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("file", new FileSystemResource(file)); // 添加文件
        requestBody.add("test", "testResttemplateUpload test");

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // 创建HttpEntity，将请求体和请求头封装进去
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        // 发送POST请求
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.exchange(UPLOAD_URL, HttpMethod.POST, requestEntity, String.class);
            // 获取服务器的响应状态码和响应体
            int statusCode = response.getStatusCodeValue();
            String responseBody = response.getBody();

            Assertions.assertEquals(200, statusCode);
            Assertions.assertEquals("OK", responseBody);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }


    }
}
