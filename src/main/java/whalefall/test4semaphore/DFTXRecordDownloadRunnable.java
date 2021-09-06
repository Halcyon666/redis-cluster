package whalefall.test4semaphore;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 原文链接：https://blog.csdn.net/qq_33581278/article/details/104536896
 */
public class DFTXRecordDownloadRunnable implements Runnable {
    private static final Log logger = LogFactory.getLog(DFTXRecordDownloadRunnable.class);

    private String callId;
    private String fileName;

    public DFTXRecordDownloadRunnable(String callId, String fileName) {
        super();
        this.callId = callId;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.err.println(callId + "任务已经执行" + fileName);
        logger.error(callId + "任务已经执行" + fileName);

    }

}
