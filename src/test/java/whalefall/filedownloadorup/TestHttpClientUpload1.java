package whalefall.filedownloadorup;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Halcyon
 * @since 1.0.0
 */
public class TestHttpClientUpload1 {
    // 替换为要发送的Excel文件路径
    public static final String FILE_PATH = Objects.requireNonNull(TestHttpClientUpload1.class.getResource("/exceltemplet/priceListTemplate.xlsx")).getPath();// 替换为接收文件的服务器URL
    public static final String UPLOAD_URL = "http://localhost:8080/upload1";
    private static final Logger logger = LoggerFactory.getLogger(TestHttpClientUpload1.class);

    @Test
    public void testHttpClientUpload() {

        File file = new File(FILE_PATH);

        // 创建CloseableHttpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建HttpPost请求
        HttpPost httpPost = new HttpPost(UPLOAD_URL);

        // 创建Multipart实体
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("file", file, ContentType.APPLICATION_OCTET_STREAM, file.getName());

        // 添加其他参数
        builder.addTextBody("test", "testHttpClientUpload test");

        // 设置请求实体
        HttpEntity entity = builder.build();
        httpPost.setEntity(entity);
        int statusCode = 500;
        // 发送HttpPost请求，并获取服务器的响应
        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            // 获取服务器的响应状态码
            statusCode = response.getStatusLine().getStatusCode();

            // 在这里可以处理服务器的响应，比如检查是否上传成功等
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        Assertions.assertEquals(200, statusCode);
    }

}
