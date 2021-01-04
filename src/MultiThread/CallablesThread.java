package MultiThread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallablesThread {
    public static void main(String[] args){
        List<Callable<String>> callableList= Arrays.asList(
                ()->"Thread1",
                ()-> "Thread2",
                ()-> "Thread3"
        );
        ExecutorService executorService= Executors.newWorkStealingPool();
        try {
            executorService.invokeAll(callableList).stream()
                    .map(stringFuture -> {
                        try {
                            return stringFuture.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return null;
                    })
                    .forEach(System.out::print);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
