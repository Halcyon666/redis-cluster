package whalefall.test4semaphore;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 原文链接：https://blog.csdn.net/qq_33581278/article/details/104536896
 */
public class RecordDownloadExecutorPool {
    private static final Log logger = LogFactory.getLog(RecordDownloadExecutorPool.class);

    private RecordDownloadExecutorPool() {
        logger.info("JdbcExecutorPool created!");
    }

    private static class SingletonHolder {
        private static ExecutorService instance = new ThreadPoolExecutor(
                100,
                200,
                20,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

    public static ExecutorService getInstance() {
        return SingletonHolder.instance;
    }
}
