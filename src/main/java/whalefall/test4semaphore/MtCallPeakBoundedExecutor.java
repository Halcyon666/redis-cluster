package whalefall.test4semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

/**
 * 原文链接：https://blog.csdn.net/qq_33581278/article/details/104536896
 */

public class MtCallPeakBoundedExecutor {
    private final ExecutorService executor;
    private final Semaphore semaphore;

    public MtCallPeakBoundedExecutor(ExecutorService executor, User user) {
        this.executor = executor;
        this.semaphore = new Semaphore(user.getBound());
    }

    public void submitTask(final Runnable command) {
        try {
            semaphore.acquire();
            executor.execute(() -> {
                    try {
                        command.run();
                    } finally {
                        semaphore.release();
                    }
                }
            );
        } catch (InterruptedException e) {
            semaphore.release();
        }
    }

}
