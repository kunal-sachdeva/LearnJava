package MultiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class SyncThreads {
    static int count=0;
    public static synchronized void incrementSync(){
        count+=1;System.out.println(count+" counting by:"+Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        ExecutorService executer = Executors.newFixedThreadPool(4);
        IntStream.range(0, 100).<Runnable>mapToObj(i -> SyncThreads::incrementSync).forEach(executer::submit);
    }
}
