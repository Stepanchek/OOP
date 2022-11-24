import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomPhaserTests {
    CustomPhaser phaser;
    int phase = 0;
    @BeforeEach
    void init() {
        phaser = new CustomPhaser(3);
    }

    Thread startNewThread() {
        Thread thread = new Thread(() -> {
            phase = phaser.arrive();
        });
        thread.start();
        return thread;
    }

    Thread startNewThreadWithAwait() {
        Thread thread = new Thread(() -> {
            phase = phaser.arriveAndAwaitAdvance();
        });
        thread.start();
        return thread;
    }

    Thread startNewThreadWithDeregister() {
        Thread thread = new Thread(() -> {
            phase = phaser.arriveAndDeregister();
        });
        thread.start();
        return thread;
    }

    @Test
    void shouldReachSecondPhaseWithAwait() throws InterruptedException {
        startNewThread();
        startNewThreadWithAwait();
        startNewThread();
        synchronized (this) {
            this.wait(2500);
        }
        assertEquals(1, phase);
    }

    @Test
    void shouldReachSecondPhase() throws InterruptedException {
        startNewThread();
        startNewThread();
        startNewThread();
        synchronized (this) {
            this.wait(2500);
        }
        assertEquals(1, phase);
    }

    @Test
    void shouldReachThirdPhaseWithDeregister() throws InterruptedException {
        phaser.arrive();
        startNewThreadWithDeregister();
        startNewThreadWithDeregister();
        synchronized (this) {
            this.wait(2500);
        }
        phase = phaser.arrive();
        assertEquals(2, phase);
    }
}