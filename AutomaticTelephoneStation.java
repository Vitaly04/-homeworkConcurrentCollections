import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AutomaticTelephoneStation implements Runnable {
    private Queue<String> calls;
    private volatile boolean generation = true;
    private final int NUMBEROFCALLS = 60;
    private final int TIMEOUT = 1000;

    public AutomaticTelephoneStation() {
        this.calls = new ConcurrentLinkedQueue<String>();
    }

    public boolean isGeneration() {
        return generation;
    }

    public Queue<String> getCalls() {
        return calls;
    }

    @Override
    public void run() {
        System.out.println("Начало поступления звонков");
        for (int i = 1; i <= NUMBEROFCALLS; i++) {
            String call = "номер - " + i;
            System.out.println("Поступил звонок " + call);
            calls.add(call);
            try {
                Thread.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        generation = false;
    }
}
