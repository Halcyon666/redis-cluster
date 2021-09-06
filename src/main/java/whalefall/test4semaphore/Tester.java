package whalefall.test4semaphore;

/**
 * 原文链接：https://blog.csdn.net/qq_33581278/article/details/104536896
 */
public class Tester {
    public static void main(String[] args) {
        User user = new User("001",10);
//        初始化控制线程类，100为运行的线程数量，具体可以自己定义
        MtCallPeakBoundedExecutor mtCallPeakBoundedExecutor =
                new MtCallPeakBoundedExecutor(RecordDownloadExecutorPool.getInstance(), user);
//        初始化线程处理业务类
        DFTXRecordDownloadRunnable dftxRecordDownloadRunnable = new DFTXRecordDownloadRunnable(user.getUuid(), "filename");
//        处理业务类提交给线程池进行处理业务
        for (int i = 0; i < 10; i++) {
            mtCallPeakBoundedExecutor.submitTask(dftxRecordDownloadRunnable);
        }
    }
}
