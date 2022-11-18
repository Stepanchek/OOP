
import org.example.CustomCyclicBarrier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;

import static org.junit.jupiter.api.Assertions.*;

public class CustomCyclicBarrierTests {
    CustomCyclicBarrier cyclicBarrier;
    boolean barrierReached = false;

    @BeforeEach
    void init(){
        cyclicBarrier = new CustomCyclicBarrier(() -> barrierReached = true, 3);
    }

    Thread startNewThread(){
        Thread thread = new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        return thread;
    }

    @Test
    void shouldReachBarrier() throws InterruptedException {
        startNewThread();
        startNewThread();
        startNewThread();

        synchronized (this){
            this.wait(2000);
        }

        assertTrue(barrierReached);
    }

    @Test
    void shouldReturnThreadWhichWaiting() throws InterruptedException {
        startNewThread();
        startNewThread();

        synchronized (this){
            this.wait(2000);
        }

        assertFalse(barrierReached);
        assertEquals(1, cyclicBarrier.getThreadsLeft());
    }

    @Test
    void shouldReturnAllThreadsAfterBarrierReached() throws InterruptedException {
        startNewThread();
        startNewThread();
        startNewThread();

        synchronized (this){
            this.wait(2000);
        }

        assertTrue(barrierReached);
        assertEquals(3,cyclicBarrier.getThreadsLeft());
    }

    @Test
    void shouldReturnActualThreadNumberWhenBarrierReached() throws InterruptedException {
        startNewThread();

        synchronized (this){
            this.wait(2000);
        }

        assertFalse(barrierReached);
        assertEquals(3,cyclicBarrier.getThreadsAmount());
    }

    @Test
    void shouldReturnThatNonBrokenWhenBarrierNotReached() throws InterruptedException {
        startNewThread();

        synchronized (this){
            this.wait(2000);
        }

        assertFalse(barrierReached);
        assertFalse(cyclicBarrier.isBroken());
    }

    @Test
    void shouldReturnThatBrokenWhenBarrierNotReached() throws InterruptedException {
        startNewThread();
        startNewThread();
        startNewThread();

        synchronized (this){
            this.wait(2000);
        }

        assertTrue(barrierReached);
        assertFalse(cyclicBarrier.isBroken());
    }

    @Test
    void shouldReturnThat3ThreadsAwaitingAfterReset() throws InterruptedException {
        startNewThread();
        startNewThread();

        synchronized (this) {
            this.wait(2000);
        }

        cyclicBarrier.reset();
        assertFalse(cyclicBarrier.isBroken());
        assertEquals(1, cyclicBarrier.getThreadsLeft());
    }

    @Test
    void shouldBrokeBarrierBecauseOfInterrupt() throws InterruptedException {
        Thread exampleThread = startNewThread();
        exampleThread.interrupt();
        exampleThread.join();
        assertTrue(cyclicBarrier.isBroken());
    }

    @Test
    void shouldThrowBrokenBarrierExceptionOnAwaitAfterInterrupt() throws InterruptedException {
        Thread exampleThread = startNewThread();
        exampleThread.interrupt();
        exampleThread.join();
        assertThrows(BrokenBarrierException.class, () -> cyclicBarrier.await());
    }
}
